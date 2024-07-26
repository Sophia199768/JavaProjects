package com.example.application.kafka;

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
    public NewTopic findMasterById() {
        return new NewTopic(
                "findMasterById", 1, (short)1);
    }

    @Bean
    public NewTopic findCatByIf() {
        return new NewTopic(
              "findCatById", 1, (short)1
        );
    }

    @Bean
    public NewTopic createMaster() {
        return new NewTopic(
                "createMaster", 1, (short)1
        );
    }

    @Bean
    public NewTopic createCat() {
        return new NewTopic(
                "createCat", 1, (short)1
        );
    }

    @Bean
    public NewTopic updateMasterName() {
        return new NewTopic(
                "updateMasterName", 1, (short)1
        );
    }

    @Bean
    public NewTopic updateCatName() {
        return new NewTopic(
                "updateCatName", 1, (short)1
        );
    }

    @Bean
    public NewTopic deleteMaster() {
        return new NewTopic(
                "deleteMaster", 1, (short)1
        );
    }

    @Bean
    public NewTopic deleteCat() {
        return new NewTopic(
                "deleteCat", 1, (short)1
        );
    }

    @Bean
    public NewTopic addNewCat() {
        return new NewTopic("addNewCat", 1, (short)1
        );
    }

    @Bean
    public NewTopic makeFriends() {
        return new NewTopic("makeFriends", 1, (short)1
        );
    }

    @Bean
    public NewTopic findAllMasters() {
        return new NewTopic("findAllMasters", 1, (short)1
        );
    }

    @Bean
    public NewTopic findAllCats() {
        return new NewTopic("findAllCats", 1, (short)1
        );
    }

    @Bean
    public NewTopic findAllCatsFiltered() {
        return new NewTopic("findAllCatsFiltered", 1, (short)1
        );
    }

}
