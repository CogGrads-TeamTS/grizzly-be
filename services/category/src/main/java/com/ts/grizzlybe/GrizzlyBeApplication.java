package com.ts.grizzlybe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class GrizzlyBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrizzlyBeApplication.class, args);
    }
}
