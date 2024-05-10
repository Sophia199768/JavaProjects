package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.example.application"})
@EntityScan(basePackages = "com.example.linkagecatmaster.models")
@EnableJpaRepositories(basePackages = "com.example.application.service")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
