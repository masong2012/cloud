package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VhrServer8002 {
    public static void main(String[] args) {
        SpringApplication.run(VhrServer8002.class, args);
    }
}
