package com.ssil.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssil.model.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PropertyConsumer {

    private final Logger log = LoggerFactory.getLogger(PropertyConsumer.class);

    public void consumeMessage(String message) throws IOException {
        log.info(String.format("$$ -> Consumed Message --> %s", message));
        Property property = (new ObjectMapper()).readValue(message, Property.class);
        log.info(String.format("$$ -> Property Id --> %s", property.getId()));
        log.info(String.format("$$ -> Property Title --> %s", property.getTitle()));
    }

}
