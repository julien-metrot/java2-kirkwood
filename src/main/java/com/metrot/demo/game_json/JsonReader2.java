package com.metrot.demo.game_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metrot.demo.day21.UserFromJson;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
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

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException {
        JSONObject json = readJsonFromUrl("https://raw.githubusercontent.com/julien-metrot/java2-kirkwood/master/src/main/java/com/metrot/demo/game_json/gamesJson.json");

        ObjectMapper mapper = new ObjectMapper();
        UserFromJson userFromJson = mapper.readValue(json.toString(), UserFromJson.class);
        userFromJson.getUsers().forEach(System.out::println);
    }
}