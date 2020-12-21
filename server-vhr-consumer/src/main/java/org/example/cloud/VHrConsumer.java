package org.example.cloud;

import org.example.balance.MyBibbon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "VHR-SERVER", configuration = MyBibbon.class)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.example")
public class VHrConsumer {
    public static void main(String[] args) {
        SpringApplication.run(VHrConsumer.class, args);
    }
}
