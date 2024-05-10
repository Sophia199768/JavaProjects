package com.example.microserviceforaccessingmasters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.linkagecatmaster.models")
public class MicroserviceForAccessingMastersApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceForAccessingMastersApplication.class, args);
    }

}
