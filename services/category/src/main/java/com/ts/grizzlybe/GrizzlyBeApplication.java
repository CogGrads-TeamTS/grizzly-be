package com.ts.grizzlybe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableDiscoveryClient
@EnableSwagger2
public class GrizzlyBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrizzlyBeApplication.class, args);
    }
}
