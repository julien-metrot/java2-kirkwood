package com.metrot.demo.game_json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.util.List;

public class JsonReader2 {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        GameFromJson gameFromJson = mapper.readValue(new URL("https://raw.githubusercontent.com/julien-metrot/java2-kirkwood/master/src/main/java/com/metrot/demo/game_json/gamesJson.json"), GameFromJson.class);

        // Access the list of games
        List<Game> games = gameFromJson.getGames();

        // Print the game data
        for (Game game : games) {
            System.out.println(game.toString());
        }
    }
}