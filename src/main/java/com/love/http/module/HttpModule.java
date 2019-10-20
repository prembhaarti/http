package com.love.http.module;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.inject.*;
import com.love.converter.Converter;
import com.love.converter.model.ConverterType;
import com.love.converter.module.ConverterModule;

import java.io.IOException;
import java.util.Arrays;

public class HttpModule extends AbstractModule {

    public static void main(String[] args) {
        Converter converter = getInjector().getInstance(Converter.class);
        System.out.println(converter.objToString(ConverterType.JSON,Arrays.asList(1,3,4)));
    }

    private static Injector getInjector() {
        return Guice.createInjector(new ConverterModule(),new HttpModule());
    }

    protected void configure() {
//        install(new ConverterModule());
//        install(new HttpModule());
    }

    @Provides
    @Singleton
    public HttpRequestFactory provideHttpRequestFactory() {
        return new NetHttpTransport().createRequestFactory(new HttpRequestInitializer() {

            @Override
            public void initialize(HttpRequest request) throws IOException {
                request.setParser(new JsonObjectParser(new JacksonFactory()));
            }
        });
    }
}
