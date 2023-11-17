package com.metrot.demo.game_json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameFromJson {
    @JsonProperty("games")
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }
}
