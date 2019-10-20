package com.love.http.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.love.converter.json.JsonUtil;
import com.love.core.job.model.Job;
import com.love.http.model.HttpJob;
import com.love.http.model.HttpRequest;
import com.love.http.model.HttpResponse;

import java.io.IOException;

@Singleton
public class HttpRequestHandler {

    @Inject
    private HttpService httpService;

    public Job processHttpJob(Job httpJob) throws IOException {
        HttpRequest httpRequest = JsonUtil.deser(httpJob.getRequest().toString(), HttpRequest.class);
        HttpResponse response = null;

        switch (httpRequest.getRequestType()) {
            case GET:
                response = httpService.get(httpRequest);
                break;
            case POST:
                response = httpService.post(httpRequest);
                break;
        }

        httpJob.setResponse(response.getResponse());
        httpJob.setStatus(String. valueOf(response.getStatusCode()));
        return httpJob;
    }

}
