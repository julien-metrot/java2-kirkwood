package com.metrot.music_json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Music implements Comparable<Music> {
    @JsonProperty("name")
    private String name;

    @JsonProperty("picture")
    private String picture;

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    @Override
    public int compareTo(Music other) {
        return this.name.compareTo(other.name);
    }
}
