package org.example.cloud.controller;

import org.example.cloud.api_response.APIResult;
import org.example.cloud.pojo.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HrController {

    public static final String RES_URL = "http://eureka-client-hr-service/test";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/res")
    public String res(){
        return restTemplate.getForObject(RES_URL, String.class);
    }
}
