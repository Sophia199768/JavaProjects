package com.example.microserviceforaccessingcats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.linkagecatmaster.models")
public class MicroserviceForAccessingCatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceForAccessingCatsApplication.class, args);
    }

}
