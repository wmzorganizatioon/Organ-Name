package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(){
        return "欢迎您"  + "，这是您的第 "  + " 次登录";
    }
}
