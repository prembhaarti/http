package com.love.converter;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.love.converter.model.ConverterType;

import javax.inject.Named;

@Singleton
public class Converter {

    @Inject @Named("Json")
    private IConverter jsonConverter;

    public String objToString(ConverterType type, Object obj){
        switch (type){
            case JSON:
                return jsonConverter.convertObjToString(obj);

            default:
                return null;
        }
    }

    public <T> T stringToObj(ConverterType type, String data, Class<T> clazz){
        switch (type){
            case JSON:
                return jsonConverter.convertStringObject(data, clazz);

            default:
                return null;
        }
    }
}
