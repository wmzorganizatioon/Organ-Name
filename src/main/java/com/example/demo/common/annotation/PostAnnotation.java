package com.example.demo.common.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@Author 86151
 *@date 2019/6/20 14:22
 *@description 重写PostMapping[里面存有name、params等属性未曾用到直接去除]
 *return
 */
@Target(ElementType.METHOD)          //只能在方法中作用
@Retention(RetentionPolicy.RUNTIME)      //运行时执行
@RequestMapping(
        method = {RequestMethod.POST}
)
public @interface PostAnnotation {
    String[] value() default {};
}
