package org.example.cloud.api_service;

import org.example.cloud.api_response.APIResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//熔断处理
@Component
public class HrFallbackService implements HrHystrixService{

    public APIResult hello(){
        return APIResult.successWithResult(" 熔断！！！ 从Fallback 返回 ！！！ 警告 ！！！");
    }
}
