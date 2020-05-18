package com.zy.zydtmc.optimistic;

import com.zy.zydtmc.annotation.RemoteTransaction;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * transaction切面
 * @author wuhailong
 */
@Aspect
@Component
public class TransactionAspect {
    
    @Pointcut("bean(*Service)")
    public void transaction(){}
    
    @Around("dtmJob")
    public void transaction(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        //这个是代理方法
        Method method = signature.getMethod();
        //这个才是实际方法
        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes());
        RemoteTransaction annotation = realMethod.getAnnotation(RemoteTransaction.class);
        if(annotation != null && "optimistic".equals(annotation.value())){
            TransactionUtil.createTransaction();
        }
        joinPoint.proceed();
        
    }
    
}
