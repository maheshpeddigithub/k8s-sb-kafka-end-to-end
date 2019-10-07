package com.ssil.controller;

import com.ssil.service.SchoolMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schoolapi")
public class SchoolMessageController {

    @Autowired
    private SchoolMessageProducer schoolMessageProducer;

    @PostMapping("/publish")
    public ResponseEntity<Void> postMessage(@RequestParam("message") String message) {
        schoolMessageProducer.sendMessage(message);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
