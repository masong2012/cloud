package org.example.cloud.api_response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResult<T> {
    private Integer code;
    private String message;
    private T data;

    public APIResult(Integer code, String message) {
        this(code, message, null);
    }


    public static int getCode(String key){
        int code = Integer.parseInt(MessagesUtil.get("api_response." + key + ".code"));
        return code;
    }

    public static String getMessage(String key){
        String message = MessagesUtil.get("api_response."+ key +".message");
        return message;
    }

    public static APIResult get(String key){
        return new APIResult(getCode(key), getMessage(key), null);
    }

    //    fail
    public static APIResult fail(){
        return APIResult.get("fail");
    }

    //    server error
    public static APIResult serverError(){
        return APIResult.get("server_error");
    }

    //    success
    public static APIResult success() {
        return APIResult.get("success");
    }

    public static APIResult successWithResult(Object result) {
        String successKey = "success";
        return new APIResult(getCode(successKey), getMessage(successKey), result);
    }


    //   get current request
    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request;
        }
        return null;
    }
}
