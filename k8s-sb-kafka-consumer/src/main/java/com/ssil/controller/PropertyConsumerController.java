package com.ssil.controller;

import com.ssil.service.PropertyConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class PropertyConsumerController {

    private final PropertyConsumer consumer;

    public PropertyConsumerController(PropertyConsumer consumer) {
        this.consumer = consumer;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(String message) throws IOException {
        consumer.consumeMessage(message);
    }

}
