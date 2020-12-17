package org.example.cloud.controller;

import org.example.cloud.api_response.APIResult;
import org.example.cloud.mvc.APIResultExt;
import org.example.cloud.pojo.Hr;
import org.example.cloud.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @GetMapping("/hello")
    @ResponseBody
    public List<Hr> hello(){
        return hrService.getAll();
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hello test";
    }

    @GetMapping("/res")
    @ResponseBody
    public APIResult res(){
        return APIResultExt.successWithList(()-> hrService.getAll());
//        return APIResult.success();
//        return APIResult.fail("hello");
//        return APIResult.successWithResult("hello");
    }
}
