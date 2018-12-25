package com.vbn.platform.entitys;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by vbn on 2018/12/18.
 */
public class JSONResult {
    public static JSONObject fillResultString(Integer status, String message, Object result) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("msg", message);
        jsonObject.put("data", result);
        return jsonObject;
    }
}
