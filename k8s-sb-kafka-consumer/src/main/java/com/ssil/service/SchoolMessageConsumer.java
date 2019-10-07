package com.ssil.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SchoolMessageConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(SchoolMessageConsumer.class);

    @KafkaListener(topics = "YEAR1", groupId = "group1")
    public void cosumeMessage(String message) {
        LOGGER.info(String.format("$$ -> Consumed Message --> %s", message));
    }

}
