package com.example.demo.common.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *@Author 86151
 *@date 2019/8/5 15:16
 *@description kafka   消费者类
 *return
 */
@Component
public class MyConsumer {

    static final Logger logger = LoggerFactory.getLogger(MyConsumer.class);

    @KafkaListener(topics = "myTopic")
    public void listener(ConsumerRecord<?,String> consumerRecord){
        String value = consumerRecord.value();

        logger.info(value);
        logger.info(String.valueOf(consumerRecord));

    }
}
