package com.example.demo.common.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@Author 86151
 *@date 2019/6/20 14:48
 *@description 重写GetMapping
 *return
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(
        method = {RequestMethod.GET}
)
public @interface GetAnnotation {
    String[] value() default {};
}
