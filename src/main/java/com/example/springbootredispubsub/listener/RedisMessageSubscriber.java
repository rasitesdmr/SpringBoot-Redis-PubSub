package com.example.springbootredispubsub.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisMessageSubscriber implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisMessageSubscriber.class);

    public static List<String> messageList = new ArrayList<>();

    /**
     * Callback for processing received objects through Redis.
     *
     * @param message message must not be {@literal null}.
     * @param pattern pattern matching the channel (if specified) - can be {@literal null}.
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        LOGGER.info("Mesaj Alındı : {}" ,message.toString());
    }
}
