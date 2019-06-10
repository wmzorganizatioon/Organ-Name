package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableAutoConfiguration
//@RequestMapping(value = "admin/")
//@RestController
@SpringBootApplication
public class DemosApplication extends SpringBootServletInitializer {

//	@RequestMapping(value = "openproject")
//	public String openPage(){
//		return "欢迎您"  + "，这是您的第 "  + " 次登录";
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemosApplication.class, args);
	}

	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

}
