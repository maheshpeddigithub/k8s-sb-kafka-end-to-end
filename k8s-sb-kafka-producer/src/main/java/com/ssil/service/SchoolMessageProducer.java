package com.ssil.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SchoolMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolMessageProducer.class);
    private static final String TOPIC = "YEAR1";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        LOGGER.info(String.format("$$ -> Producing Message --> %s", message));
        kafkaTemplate.send(TOPIC, message);
    }

}
