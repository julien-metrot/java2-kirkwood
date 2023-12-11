package com.metrot.music_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metrot.demo.day21.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "musicJsonServlet", value = "/music-json")
public class MusicJsonServlet extends HttpServlet {
    private static List<Music> music;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("music", music);
        req.getRequestDispatcher("WEB-INF/day21/music-json.jsp").forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        JSONObject json = null;
        try {
            json = JsonReader.readJsonFromUrl("https://api.deezer.com/search/artist?q=name&picture");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MusicFromJson musicFromJson = null;
        try {
            musicFromJson = mapper.readValue(json.toString(), MusicFromJson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        this.music = musicFromJson.getMusic();
    }
}
