package com.example.demo.common.annotation;

import java.lang.annotation.*;

/**
 *@Author 86151
 *@date 2019/6/19 16:35
 *@description 自定义注解[全局false]
 *return
 */
@Target({ElementType.FIELD,ElementType.METHOD})        //作用范围
@Retention(RetentionPolicy.RUNTIME)       //保留在什么状态下【①编译前；②编译；③运行】
@Documented                         //表示注解会被包含在javaapi文档中
@Inherited                      //运行被子类继承
public @interface BooleanAnnotation {

    boolean isRest() default false;

}
