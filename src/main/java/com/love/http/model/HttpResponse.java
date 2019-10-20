package com.love.http.model;

import lombok.Data;

@Data
public class HttpResponse {
    private String response;
    private Integer statusCode;

    public HttpResponse(String response, Integer statusCode) {
        this.response = response;
        this.statusCode = statusCode;
    }
}
