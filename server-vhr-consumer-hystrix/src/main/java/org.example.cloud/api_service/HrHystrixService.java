package org.example.cloud.api_service;

import org.example.cloud.api_response.APIResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "VHR-SERVER", fallback = HrFallbackService.class)
public interface HrHystrixService {

    @GetMapping("/hello")
    public APIResult hello();

}
