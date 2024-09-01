package com.kss.kafka.service;


import com.kss.kafka.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

//    @KafkaListener(topics = "kss-topic-1", groupId = "kss-group-1")
//    public void consume1(String message){
//        log.info("1 Consumed message {} ", message);
//    }
//
//    @KafkaListener(topics = "kss-topic-1", groupId = "kss-group-1")
//    public void consume2(String message){
//        log.info("2 Consumed message {} ", message);
//    }
//
//    @KafkaListener(topics = "kss-topic-1", groupId = "kss-group-1")
//    public void consume3(String message){
//        log.info("3 Consumed message {} ", message);
//    }
//    @KafkaListener(topics = "kss-topic-1", groupId = "kss-group-1")
//    public void consume4(String message){
//        log.info("4 Consumed message {} ", message);
//    }

    @KafkaListener(topics = "kss-topic", groupId = "kss-group")
    public void consume(Customer customer){
        log.info("Customer object message {} ", customer.toString());
    }





}
