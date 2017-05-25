package com.example.ths.demoretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ths on 12/05/2017.
 */

public class User {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
