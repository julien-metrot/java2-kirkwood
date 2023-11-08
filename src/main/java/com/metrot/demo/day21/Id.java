package com.metrot.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Id{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
