package com.example.ths.demologinmvp.data;


/**
 * Created by ths on 12/05/2017.
 */

public class User {
    private String name;
    private String picture;

    public User() {
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User(String name, String picture) {
        this.name = name;
        this.picture = picture;
    }

    public User(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
