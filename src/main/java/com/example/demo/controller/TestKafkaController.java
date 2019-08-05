package com.example.demo.controller;

import com.example.demo.common.annotation.GetAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *@Author 86151
 *@date 2019/8/5 15:12
 *@description kafka实践类
 *return
 */
@RestController
public class TestKafkaController {

    @Autowired
    private KafkaTemplate<String,String> kvKafkaTemplate;

    /**
     *@Author 86151
     *@Date 2019/8/5 15:12
     *Description kafka方法  【这里的myTopic就是指的kafka的队列，我更愿意称之为容器，消费者从中拿生产者发出的请求】
     @Param
     *return
     */
    @GetMapping("/sendKafka")
    public String send(String name){
        kvKafkaTemplate.send("myTopic",name);
        return name;
    }
}
