package com.example.exercise2eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Exercise2EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Exercise2EurekaServerApplication.class, args);
    }
}