package com.example.springbootredispubsub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class PublisherMessageImpl implements PublisherMessage {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    ChannelTopic topic;

    public PublisherMessageImpl(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    @Override
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);

    }
}
