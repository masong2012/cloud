package org.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.api.HrFeign;
import org.example.cloud.api_response.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class VHrConsumerController {

    //    相比直接调用，用服务名字，省略了域名配置，更加智能
    public static final String URL = "http://VHR-SERVER";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/hello")
    public APIResult consumer_hello(){
        log.info("******** -------> consumer Hello <--------- ********");
        return restTemplate.getForObject(URL + "/hello", APIResult.class);
    }


    //    进一步封装，URL都省了, 不用每次都写URL，更加简洁
    @Resource
    private HrFeign hrFeign;

    @GetMapping("/consumer/feign/hello")
    public APIResult consumer_feign_hello(){
        log.info("******** -------> consumer feign Hello <--------- ********");
        return hrFeign.hello();
    }

}
