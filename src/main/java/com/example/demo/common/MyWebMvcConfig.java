package com.example.demo.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *ClassDescription 用于springboot全局配置跨域类【之后接口就不需要在调用此注解[@CrossOrigin]了】
 *@Author Wisdom
 *@Date 2019/5/11 0011
 *@return
 **/
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedHeaders("*")
                .maxAge(1800)
                .allowedOrigins("http://localhost:8093")
                .allowedMethods("*");
    }
}
