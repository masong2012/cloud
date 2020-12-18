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
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @GetMapping("/direct")
    public String direct(){
        return "This is direct Call";
    }

    @GetMapping("/list_hr")
    public List<Hr> hello(){
        return hrService.getAll();
    }

    @GetMapping("/string")
    public String test(){
        return "hello test";
    }

    @GetMapping("/res_fail")
    public APIResult<Hr> res_fail(HttpServletResponse response){
        return APIResult.fail();
    }

    @GetMapping("/res_success")
    public APIResult<Hr> res_success(HttpServletResponse response){
        return APIResult.success();
    }

    @GetMapping("/res_list")
    public APIResult<Hr> res(HttpServletResponse response){
        return APIResultExt.successWithList(()-> hrService.getAll());
    }

    @GetMapping("/res_item")
    public APIResult<Hr> res_hr(HttpServletResponse response) {
        return APIResult.successWithResult(hrService.getById(3));
    }
}
