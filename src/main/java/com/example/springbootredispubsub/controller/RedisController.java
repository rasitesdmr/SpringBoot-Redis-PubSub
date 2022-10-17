package com.example.springbootredispubsub.controller;

import com.example.springbootredispubsub.listener.RedisMessageSubscriber;
import com.example.springbootredispubsub.model.UserMessage;
import com.example.springbootredispubsub.service.PublisherMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    PublisherMessage publisherMessage;

    @PostMapping("/publish")
    public void publish(@RequestBody UserMessage userMessage) {
        LOGGER.info("Mesaj Gönderiliyor... : {}", userMessage.getMessage());
        publisherMessage.publish(userMessage.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessage() {
        return RedisMessageSubscriber.messageList;
    }


}
