package com.metrot.game_db;

import com.metrot.data_access.GameDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "gameDBservlet", value = "/games-db")
public class GameDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("games", GameDAO.getAll());
        req.getRequestDispatcher("WEB-INF/game_db_view/games-db.jsp").forward(req, resp);
    }
}
