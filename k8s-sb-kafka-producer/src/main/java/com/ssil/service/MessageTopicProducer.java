package com.ssil.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssil.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageTopicProducer {

    private static final Logger log = LoggerFactory.getLogger(MessageTopicProducer.class);

    private final String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageTopicProducer(KafkaTemplate<String, String> kafkaTemplate,
                                @Value("${spring.kafka.producer.topic-name}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void publishMessage(Book book) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(book);
        log.info(String.format("$$ -> Producing Message --> %s", message));
        kafkaTemplate.send(topic, message);
    }

}
