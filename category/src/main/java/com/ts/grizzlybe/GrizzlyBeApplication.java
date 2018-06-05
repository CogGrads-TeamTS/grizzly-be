package com.ts.grizzlybe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableEurekaClient
@EnableSwagger2
public class GrizzlyBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrizzlyBeApplication.class, args);
    }
}
