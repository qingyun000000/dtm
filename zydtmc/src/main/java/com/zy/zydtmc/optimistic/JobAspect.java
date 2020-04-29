package com.zy.zydtmc.optimistic;

import com.zy.zydtmc.annotation.RemoteTransaction;
import com.zy.zydtmc.annotation.RollbackMethod;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * job切面, 此方案备用，暂时放弃，换注解嵌套
 * @author wuhailong
 */
//@Aspect
//@Component
public class JobAspect {
    
    @Pointcut("bean(*Controller)")
    public void dtmJob(){}
    
    @Around("dtmJob")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        if(!"true".equals(request.getParameter("rollbackSign"))){
            joinPoint.proceed();
            return;
        }
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        //这个是代理方法
        Method method = signature.getMethod();
        //遍历目标类的方法，根据注解找到回滚方法
        Method[] declaredMethods = joinPoint.getTarget().getClass().getDeclaredMethods();
        for(Method mth : declaredMethods){
            RollbackMethod annotation = mth.getAnnotation(RollbackMethod.class);
            if(annotation != null && signature.getName().equals(annotation.value())){
                //转到回滚方法执行
                method.invoke(joinPoint.getTarget(), joinPoint.getArgs());
            }
        }
        
    }
    
}
