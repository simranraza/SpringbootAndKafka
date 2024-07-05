package com.genius.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
@Slf4j
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;


    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> publishMessage(@RequestBody MessageRequest messageRequest) {
        log.info("Received :" + messageRequest.getMessage());
        kafkaTemplate.send("geniusCode",messageRequest.getMessage());
        return new ResponseEntity<String>(messageRequest.getMessage(), HttpStatus.OK);
    }
}
