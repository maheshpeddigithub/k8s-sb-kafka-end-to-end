package com.ssil.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssil.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageTopicProducer {

    private static final Logger log = LoggerFactory.getLogger(MessageTopicProducer.class);
    private static final String TOPIC = "message-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageTopicProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(Book book) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(book);
        log.info(String.format("$$ -> Producing Message --> %s", message));
        kafkaTemplate.send(TOPIC, message);
    }

}
