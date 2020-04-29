package com.zy.zydtmc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注解：远程服务
 * @author wuhailong
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@RestController(value = "" + value)
public @interface RemoteTransaction {
    
    String type() default "optimistic";
    
    @AliasFor(annotation = RestController.class)
    String value();
}
