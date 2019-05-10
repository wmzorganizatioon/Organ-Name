package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration
//@RequestMapping(value = "admin/")
//@RestController
@SpringBootApplication
public class DemosApplication {

//	@RequestMapping(value = "openproject")
//	public String openPage(){
//		return "欢迎您"  + "，这是您的第 "  + " 次登录";
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemosApplication.class, args);
	}

}
