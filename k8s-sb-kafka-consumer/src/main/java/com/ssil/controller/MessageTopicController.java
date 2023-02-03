package com.ssil.controller;

import com.ssil.service.MessageTopicConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class MessageTopicController {

    private final MessageTopicConsumer consumer;

    public MessageTopicController(MessageTopicConsumer consumer) {
        this.consumer = consumer;
    }

    @KafkaListener(topics = "message-topic", groupId = "group1")
    public void consumeMessage(String message) throws IOException {
        consumer.consumeMessage(message);
    }

}
