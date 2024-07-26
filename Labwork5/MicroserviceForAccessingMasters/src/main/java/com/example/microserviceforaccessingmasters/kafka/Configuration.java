package com.example.microserviceforaccessingmasters.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public NewTopic sendTopic() {
        return new NewTopic(
                "sendKafka", 1, (short)1);
    }

    @Bean
    public NewTopic receive() {
        return new NewTopic(
                "receiveKafka", 1, (short)1);
    }

    @Bean
    public NewTopic addNewCat() {
        return new NewTopic(
                "addNewModelCat", 1, (short)1);
    }

    @Bean
    public NewTopic allMasters() {
        return new NewTopic(
                "allMasters", 1, (short)1);
    }


    @Bean
    public NewTopic findMaster() {
        return new NewTopic(
                "findMaster", 1, (short)1);
    }
}
