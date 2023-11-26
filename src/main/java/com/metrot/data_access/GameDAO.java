package com.metrot.data_access;

import com.metrot.game_db.Game;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO extends Database{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }

    public static List<Game> getAll() {
        List<Game> games = new ArrayList<>();
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (
                        CallableStatement statement = connection.prepareCall("{CALL sp_read_savings()}");
                        ResultSet resultSet = statement.executeQuery();
                ) {
                    while (resultSet.next()) {
                        int game_ID = resultSet.getInt("game_ID");
                        String game_name = resultSet.getString("game_name");
                        String release_price = resultSet.getString("release_price");
                        int person_ID = resultSet.getInt("person_ID");
                        String first_name = resultSet.getString("first_name");
                        String last_name = resultSet.getString("last_name");
                        String purchase_price = resultSet.getString("purchase_price");
                        String savings = resultSet.getString("savings");
                        Game game = new Game(game_ID, game_name, release_price, person_ID, first_name, last_name, purchase_price, savings);
                        games.add(game);
                    }
                }
            }
        } catch (SQLException e) {
            showError(e);
        } catch (ClassNotFoundException e) {

        }
        return games;
    }
}
