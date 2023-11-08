package com.metrot.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

public class GameFromJson {
    @JsonProperty("games")
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }
}
