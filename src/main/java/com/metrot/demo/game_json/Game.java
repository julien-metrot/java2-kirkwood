package com.metrot.demo.game_json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game implements Comparable<Game> {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("platform")
    private String platform;

    @JsonProperty("release_date")
    private String release_date;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public int compareTo(Game other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Game:\n\t" +
                "title='" + title + '\'' +
                "\n\tdescription='" + description + '\'' +
                "\n\tgenre='" + genre + '\'' +
                "\n\tplatform='" + platform + '\'' +
                "\n\trelease_date='" + release_date + '\'' +
                "";
    }
}
