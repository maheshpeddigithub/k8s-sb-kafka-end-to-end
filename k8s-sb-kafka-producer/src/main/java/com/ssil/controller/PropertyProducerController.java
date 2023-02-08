package com.ssil.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssil.model.Property;
import com.ssil.service.PropertyProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PropertyProducerController {

    private final PropertyProducer producer;

    public PropertyProducerController(PropertyProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<Void> publishMessage(@RequestBody Property property) throws JsonProcessingException {
        producer.publishMessage(property);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
