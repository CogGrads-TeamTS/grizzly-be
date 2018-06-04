package com.example.namingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NamingDemoApplication.class, args);
    }
}
