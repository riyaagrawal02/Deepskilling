package com.cognizant.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = {"com.cognizant.rest"})
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("Spring REST API with JWT Authentication");
        System.out.println("========================================\n");
    }
}
