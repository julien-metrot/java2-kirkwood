package com.metrot.music_json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MusicFromJson {
    @JsonProperty("results")
    private List<Music> music;

    public List<Music> getMusic() {
        return music;
    }
}
