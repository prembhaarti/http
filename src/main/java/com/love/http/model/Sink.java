package com.love.http.model;

import com.love.http.model.enums.SinkType;
import lombok.Data;

@Data
public class Sink {
    private SinkType type;
    private String path;
}
