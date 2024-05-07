package com.example.microserviceforaccessingcats.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public NewTopic allCats() {
        return new NewTopic(
                "allCats", 1, (short)1);
    }

}
