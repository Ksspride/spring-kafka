package com.kss.kafka.service;

import com.kss.kafka.dto.Customer;
import com.kss.kafka.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message){
//        CompletableFuture<SendResult<String, Object>> future = template.send("test-topic", 3, null, message);
//        future.whenComplete((result, ex)->{
//           if(ex==null){
//               System.out.println("Sent message=["+ message +"] with offset=["+ result.getRecordMetadata().offset() +"]");
//           } else {
//               System.out.println("Unable sent message=["+ message +"] due to=["+ ex.getMessage() +"]");
//           }
//        });


        template.send("test-topic", 2, null, "Youtube");
        template.send("test-topic", 2, null, "Instagram");
        template.send("test-topic", 2, null, "Google");
        template.send("test-topic", 0, null, message);
        template.send("test-topic", 1, null, "Git");
    }

    public void sendObjectMessageToTopic(Customer customer){
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("kss-topic", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent object message=[" + customer.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable sent object message=[" + customer.toString() + "] due to=[" + ex.getMessage() + "]");
                }
            });
        }catch (Exception e){
            System.out.println("ERROR: While sending customer object "+e.getMessage());
        }
    }


    public void sendDTLMessageToTopic(User user){
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("new-kss-topic", user);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent object message=[" + user.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable sent object message=[" + user.toString() + "] due to=[" + ex.getMessage() + "]");
                }
            });
        }catch (Exception e){
            System.out.println("ERROR: While sending user object "+e.getMessage());
        }
    }

}
