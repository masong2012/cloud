package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrConsumerServer {
    public static void main(String[] args) {
        SpringApplication.run(HrConsumerServer.class, args);
    }
}
