package com.ssil.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssil.model.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PropertyProducer {

    private static final Logger log = LoggerFactory.getLogger(PropertyProducer.class);

    private final String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PropertyProducer(KafkaTemplate<String, String> kafkaTemplate,
                            @Value("${spring.kafka.producer.topic-name}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void publishMessage(Property property) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(property);
        log.info(String.format("$$ -> Producing Message --> %s", message));
        kafkaTemplate.send(topic, message);
    }

}
