package com.metrot.demo.day28;

import com.metrot.data_access.UserDAO;
import com.metrot.demo.day25.User;
import com.metrot.project.utilities.PasswordUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static Map<String, String> results = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/day28/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("inputEmail1");
        String password = req.getParameter("inputPassword1");
        String[] rememberMe = req.getParameterValues("rememberCheck1");

        results.clear();
        results.put("email", email);
        results.put("password", password);
        if(rememberMe!= null && rememberMe[0].equals("true")) {
            results.put("rememberMe", rememberMe[0]);
        }  else {
            results.put("rememberMe", "");
        }

        try {
            User userFromDatabase = UserDAO.get(email);
            if (userFromDatabase == null) {
                // Email not found
                results.put("loginFail", "No user found with that email and password combination.");
            } else {
                // Email is found
                if (!PasswordUtility.checkpw(password, String.valueOf(userFromDatabase.getPassword()))) {
                    // Passwords don't match
                    String userStatus = userFromDatabase.getStatus();
                    int attemptsLeft = 5;
                    while (userStatus.equals("active") && attemptsLeft > 0) {
                        results.put("loginFail", "No user found with that email and password combination. Attempts left: " + attemptsLeft);
                        attemptsLeft--;
                    }
                        userFromDatabase.setStatus("locked");
                        results.put("loginFail", "You have reached the maximum number of attempts. Please reset your password.");
                } else {
                    // Passwords match
                    results.put("loginSuccess", "Welcome back!");
                }
            }
        } catch (Exception e) {
            results.put("loginFail", "Cannot log you in. Try again later.");
        }


        req.setAttribute("results", results);
        req.getRequestDispatcher("WEB-INF/day28/login.jsp").forward(req, resp);
    }
}
