package com.love.http.model;

import com.love.http.model.enums.SourceType;
import lombok.Data;

@Data
public class Source {
    private SourceType type;
    private String path;
}
