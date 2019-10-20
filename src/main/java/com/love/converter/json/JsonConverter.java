package com.love.converter.json;

import com.google.inject.Singleton;
import com.love.converter.IConverter;

@Singleton
public class JsonConverter implements IConverter{

    @Override
    public <T> String convertObjToString(T object) {
        return JsonUtil.serialise(object);
    }

    @Override
    public <T> T convertStringObject(String data, Class<T> clazz) {
        return JsonUtil.deser(data, clazz);
    }
}
