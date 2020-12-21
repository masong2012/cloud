package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer9001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer9001.class, args);
    }
}
