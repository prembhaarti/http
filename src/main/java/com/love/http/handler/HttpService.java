package com.love.http.handler;

import com.google.inject.Singleton;
import com.love.http.model.HttpRequest;
import com.love.http.model.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

@Singleton
public class HttpService {

    public HttpResponse post(HttpRequest httpRequest) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(httpRequest.getUrl());
        StringEntity entity = new StringEntity(httpRequest.getPayload().toString());
        httpPost.setEntity(entity);
        addHeaders(httpRequest, httpPost);

        CloseableHttpResponse response = client.execute(httpPost);
        HttpResponse httpResponse = getHttpResponse(response);
        client.close();
        return httpResponse;
    }

    public HttpResponse get(HttpRequest httpRequest) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(httpRequest.getUrl());
        addHeaders(httpRequest, httpGet);

        CloseableHttpResponse response = client.execute(httpGet);
        HttpResponse httpResponse = getHttpResponse(response);
        client.close();
        return httpResponse;
    }

    private void addHeaders(HttpRequest httpRequest, HttpPost httpPost) throws IOException {
        Map<String,String> headers = httpRequest.getHeaders();
        for(String key: headers.keySet()){
            httpPost.setHeader(key, headers.get(key));
        }
    }

    private void addHeaders(HttpRequest httpRequest, HttpGet httpGet) throws IOException {
        Map<String,String> headers = httpRequest.getHeaders();
        for(String key: headers.keySet()){
            httpGet.setHeader(key, headers.get(key));
        }
    }

    private HttpResponse getHttpResponse(CloseableHttpResponse response) throws IOException {
        return new HttpResponse(EntityUtils.toString(response.getEntity()),response.getStatusLine().getStatusCode());
    }

}
