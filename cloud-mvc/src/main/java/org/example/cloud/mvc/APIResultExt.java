package org.example.cloud.mvc;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.cloud.api_response.APIResult;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class APIResultExt extends org.example.cloud.api_response.APIResult {

    public APIResultExt(int code, String message, Object data) {
        super(code, message, data);
    }

    public interface SelectorCallback{
        void doCallback();
    }
    public static APIResult successWithList(SelectorCallback selector){
        int page = 1;
        int size = 20;
        HttpServletRequest req = APIResultExt.getCurrentRequest();
        if (req != null){
            String s_page = req.getParameter("page");
            if(s_page != null){ page = Integer.parseInt(s_page); }

            String s_size = req.getParameter("size");
            if(s_page != null){ size = Integer.parseInt(s_size); }
        }

        Page p = PageHelper.startPage(page,size).doSelectPage(()-> selector.doCallback());

        long total_rows = p.getTotal();
        HashMap result = new HashMap();
        result.put("total_rows",total_rows);
        result.put("rows",p.getResult());

        return APIResultExt.successWithResult(result);
    }


}
