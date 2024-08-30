package com.kss.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducreConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("kss-topic-1", 5, (short) 1);
    }


}
