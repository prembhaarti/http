package com.love.converter.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.love.converter.Converter;
import com.love.converter.IConverter;
import com.love.converter.json.JsonConverter;

public class ConverterModule extends AbstractModule {
    private static final String JSON = "Json";

    @Override
    protected void configure() {
        bind(Converter.class);
        bind(IConverter.class)
                .annotatedWith(Names.named(JSON))
                .to(JsonConverter.class);
    }
}
