package org.example.cloud.controller;

import org.example.cloud.api_response.APIResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HrController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello")
    public APIResult hello(){
        return APIResult.successWithResult("Hello From Port :" + serverPort);
    }

}
