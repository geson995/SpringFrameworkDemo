package com.springmvc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: geson
 * @Date:2019/1/8 19:09
 */
public class ResponseData {
    private String message;
    private int code;
    private final Map<String, Object> data = new HashMap<>();

    private ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public static ResponseData ok() {
        return new ResponseData(200, "OK");
    }

//    public static ResponseData notFound(){
//        return new ResponseData(404, "Not Found");
//    }

    public static ResponseData error(String errorMessage) {
        return new ResponseData(-1, errorMessage);
    }

//    public static ResponseData unauthorized() {
//        return new ResponseData(401, "unauthorized");
//    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
