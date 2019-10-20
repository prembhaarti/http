package com.love.converter;

public interface IConverter {

    <T> String convertObjToString(T object);
    <T> T convertStringObject(String data, Class<T> clazz);
}
