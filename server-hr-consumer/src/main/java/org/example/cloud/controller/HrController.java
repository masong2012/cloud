package org.example.cloud.controller;

import org.example.cloud.api_response.APIResult;
import org.example.cloud.pojo.Hr;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;



//@Slf4j
@RestController
public class HrController {

    public static final String BASE_HR_URL = "http://eureka-client-hr-service/hr/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/direct")
    public String direct(){
        String url = "http://localhost:8001/hr/direct";
        return (new RestTemplate()).getForObject(url, String.class,"a=1");
    }


    @GetMapping("/string")
    public String string(){
        String url = BASE_HR_URL + "string";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/list_hr")
    public List<Hr> list_hr(){
        String url = BASE_HR_URL + "list_hr";
        return restTemplate.getForObject(url, List.class);
    }


    @GetMapping("/res_fail")
    public APIResult res_fail(){
        String url = BASE_HR_URL + "res_fail";
        return restTemplate.getForObject(url, APIResult.class);
    }

    @GetMapping("/res_success")
    public APIResult res_success(){
        String url = BASE_HR_URL + "res_success";
        return restTemplate.getForObject(url, APIResult.class);
    }


    @GetMapping("/res_list")
    public APIResult res_list(){
        String url = BASE_HR_URL + "res_list";
        return restTemplate.getForObject(url, APIResult.class);
    }


    @GetMapping("/res_item")
    public APIResult res_hr(){
        String url = BASE_HR_URL + "res_item";
        return restTemplate.getForObject(url, APIResult.class);
    }

    public static String post(String url, String data, String token)
            throws Exception {
        HttpHeaders headers = new HttpHeaders();
		/*headers.add(HttpHeadersImpl.ACCEPT, "application/json");
		headers.add(HttpHeadersImpl.ACCEPT_ENCODING, "gzip");
		headers.add(HttpHeadersImpl.CONTENT_ENCODING, "UTF-8");
		headers.add(HttpHeadersImpl.CONTENT_TYPE,
				"application/json; charset=UTF-8");
		headers.add(HttpHeadersImpl.COOKIE, token);
		headers.add("Token", token);*/
        headers.add("Accept", "application/json");
        headers.add("Accpet-Encoding", "gzip");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Token", token);

        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return (new RestTemplate()).postForObject(url, formEntity, String.class);
    }

}
