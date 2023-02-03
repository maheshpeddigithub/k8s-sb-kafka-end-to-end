package com.ssil.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssil.model.Book;
import com.ssil.service.MessageTopicProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageTopicController {

    private final MessageTopicProducer producer;

    public MessageTopicController(MessageTopicProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<Void> publishMessage(@RequestBody Book book) throws JsonProcessingException {
        producer.publishMessage(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
