package com.love.http.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.love.converter.json.JsonUtil;
import com.love.http.model.enums.ContentType;
import com.love.http.model.enums.RequestType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class HttpRequest {
    private String url;
    private RequestType requestType = RequestType.POST;
    private JsonNode payload;
    private Map<String,String> headers = new HashMap<>();
    private ContentType contentType = ContentType.JSON;

    public String toJson(){
        return JsonUtil.serialise(this);
    }
}
