package org.example.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback(){
        return "ERROR!!  服务暂时不可用, 稍后再试";
    }
}
