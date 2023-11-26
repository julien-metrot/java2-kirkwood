package com.metrot.game_db;

public class Game {
    private int game_ID;
    private String game_name;
    private String release_price;
    private int person_ID;
    private String first_name;
    private String last_name;
    private String purchase_price;
    private String savings;

    public Game(int game_ID, String game_name, String release_price, int person_ID, String first_name, String last_name, String purchase_price, String savings) {
        this.game_ID = game_ID;
        this.game_name = game_name;
        this.release_price = release_price;
        this.person_ID = person_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.purchase_price = purchase_price;
        this.savings = savings;
    }

    public int getGame_ID() {
        return game_ID;
    }

    public String getGame_name() {
        return game_name;
    }

    public String getRelease_price() {
        return release_price;
    }

    public int getPerson_ID() {
        return person_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPurchase_price() {
        return purchase_price;
    }

    public String getSavings() {
        return savings;
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_ID=" + game_ID +
                ", game_name='" + game_name + '\'' +
                ", release_price='" + release_price + '\'' +
                ", person_ID=" + person_ID +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", purchase_price='" + purchase_price + '\'' +
                ", savings='" + savings + '\'' +
                '}';
    }
}
