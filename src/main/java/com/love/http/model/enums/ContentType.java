package com.love.http.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ContentType {
    JSON("application/json"), URL_ENCODED("application/x-www-form-urlencoded"), TEXT("application/text-plain");
    private String type;

    @JsonCreator
    ContentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
