package com.example.task.response;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Response<T> {

    private String message;
    private int status_code = 0;
    private String serverTime;
    private T body;

    public Response() {}

    public Response(String message, int status_code, T body) {

        this.message = message;
        this.status_code = status_code;
        this.body = body;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
        this.serverTime = dateFormat.format(new Date());

    }

}
