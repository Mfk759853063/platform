package com.vbn.platform.interceptor;

import com.vbn.platform.entitys.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by vbn on 2018/12/18.
 */

@ControllerAdvice
public class GloabExceptionHandler {
    static public String handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "server error";
        }
        return JSONResult.fillResultString(-1, msg, "").toJSONString();
    }
}
