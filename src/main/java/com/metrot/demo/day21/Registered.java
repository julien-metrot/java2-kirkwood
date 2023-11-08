package com.metrot.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Registered {
    @JsonProperty("date")
    private String date;
    @JsonProperty("age")
    private String age;

    public String getDate() {
        return date;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Registered{" +
                "date='" + date + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
