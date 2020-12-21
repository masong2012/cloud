package org.example.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.api_response.APIResult;
import org.example.cloud.api_service.HrHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@DefaultProperties(defaultFallback = "hr_global_fallbackMethod")
public class VHrConsumerController {


    @Resource
    private HrHystrixService hrFeign;

    @GetMapping("/consumer/feign/hello")
//    @HystrixCommand
    public APIResult consumer_feign_hello(){
        log.info("******** -------> consumer feign Hello <--------- ********");
        return hrFeign.hello();
    }

    public APIResult hr_global_fallbackMethod(){
        return APIResult.successWithResult("Fallback .!!! hr_global_fallbackMethod");
    }

}
