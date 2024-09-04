package com.kss.kafka.service;

import com.kss.kafka.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class KafkaUserMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaUserMessageListener.class);

    @RetryableTopic(attempts = "4")// n-1 =3//, backoff  = @Backoff(delay = 3000,multiplier = 1.5, maxDelay = 15000)
    @KafkaListener(topics = "new-kss-topic", groupId = "new-kss-group")
    public void consumeUser(User user, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset){
        if(user.getIpAddress().contains("192.188.1.1")){
            throw new RuntimeException("Invalid IP address received");
        }
        log.info("User object message {} ", user);
    }

    @DltHandler
    public void listenDLT(User user, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset){
        log.info("DLT Received : {}, from {}, offset {} ", user.getName(), topic, offset);
    }


}
