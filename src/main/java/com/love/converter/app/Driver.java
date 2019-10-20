package com.love.converter.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.love.converter.Converter;
import com.love.converter.json.JsonUtil;
import com.love.converter.model.ConverterType;
import com.love.converter.module.ConverterModule;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {
        Injector injector = getInjector();
        Converter converter = injector.getInstance(Converter.class);
        System.out.println(converter.objToString(ConverterType.JSON, new Book("Java", "1")));

        String header = "{\"Content-Type\":\"application/json\",\"X-PERF-TEST\":false,\"DE-CLIENT-CONTEXT\":\"CART\",\"X-CLIENT-ID\":\"cart\"}";
        System.out.println(JsonUtil.serializeToMap(header));
    }

    private static Injector getInjector() {
        return Guice.createInjector(new ConverterModule());
    }
}
