package com.metrot.demo.game_json;

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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name="gameJsonServlet", value="/game-json")
public class GameJsonServlet extends HttpServlet {
    private static List<Game> games;
    private static List<String> genres;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("q");
        String sort = req.getParameter("sort");
        String q = query != null ? query : "";
        sort = sort != null ? sort : "";
        String genreIn = req.getParameter("genre");
        String genre = genreIn != null ? genreIn : "";


        List<Game> copy = new ArrayList<>(games);
        if (!q.isBlank()) {
            copy.removeIf(game -> !game.getTitle().toLowerCase().contains(q.toLowerCase()));
        }
        if (!genre.isBlank()) {
            copy.removeIf(game -> !game.getGenre().equalsIgnoreCase(genre));
        }

        if (sort.equals("az")) {
            Collections.sort(copy);
        } else {
            copy.sort(Comparator.reverseOrder());
        }

        req.setAttribute("games", copy);
        req.setAttribute("genres", genres);
        req.setAttribute("q", q);
        req.setAttribute("s", sort);

        req.getRequestDispatcher("WEB-INF/day21/game-json.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            JSONObject json = JsonReader.readJsonFromUrl("https://raw.githubusercontent.com/julien-metrot/java2-kirkwood/master/src/main/java/com/metrot/demo/game_json/gamesJson.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            GameFromJson gameFromJson = mapper.readValue(json.toString(), GameFromJson.class);
            this.games = gameFromJson.getGames();

            genres = new ArrayList<>();
            for (Game game : games) {
                String genre = game.getGenre();
                if (!genres.contains(genre)) {
                    genres.add(genre);
                }
            }
            Collections.sort(genres);

        } catch (IOException e) {

        }
    }
}