package org.example.cloud.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.api_response.APIResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/hr")
public class HrController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello")
    public APIResult hello(){
        log.info("/Hello");
        return APIResult.successWithResult("Hello From Port :" + serverPort);
    }

    @GetMapping("/get/hello")
    public APIResult get_hello(){
        log.info("/get/Hello");
        return APIResult.successWithResult("GET Hello From Port :" + serverPort);
    }

    @GetMapping("/lb/hello")
    public APIResult lb_hello(){
        log.info("/lb/Hello");
        return APIResult.successWithResult("LB  Hello From Port :" + serverPort);
    }
}
