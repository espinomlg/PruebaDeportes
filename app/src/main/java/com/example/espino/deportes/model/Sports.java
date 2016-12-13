package com.example.espino.deportes.model;

/**
 * Created by espino on 12/12/16.
 */

public class Sports {
    private String name;
    private boolean favourite;

    public Sports(String name, boolean favourite) {
        this.name = name;
        this.favourite = favourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
