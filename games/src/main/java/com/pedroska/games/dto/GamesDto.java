package com.pedroska.games.dto;

public class GamesDto {
    private String name;
    private String category;

    public GamesDto(String name) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
