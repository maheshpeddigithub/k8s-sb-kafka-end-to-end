package com.ssil.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssil.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageTopicConsumer {

    private final Logger log = LoggerFactory.getLogger(MessageTopicConsumer.class);

    @KafkaListener(topics = "message-topic", groupId = "group1")
    public void consumeMessage(String message) throws IOException {
        log.info(String.format("$$ -> Consumed Message --> %s", message));
        Book book = (new ObjectMapper()).readValue(message, Book.class);
        log.info(String.format("$$ -> Book Id --> %s", book.getId()));
        log.info(String.format("$$ -> Book Title --> %s", book.getTitle()));
    }

}
