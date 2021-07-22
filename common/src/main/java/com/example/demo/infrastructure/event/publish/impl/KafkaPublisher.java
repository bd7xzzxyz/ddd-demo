package com.example.demo.infrastructure.event.publish.impl;

import com.example.demo.infrastructure.dto.BasicEventDTO;
import com.example.demo.infrastructure.event.publish.Publisher;
import org.springframework.stereotype.Component;

/**
 * @author baodi1
 * @description: TODO
 * @date 2021/7/21 4:13 下午
 */
@Component("kafkaPublisher")
public class KafkaPublisher implements Publisher {

    @Override
    public <T extends BasicEventDTO> void publish(T message) {
        //调用kafa发mq
    }
}
