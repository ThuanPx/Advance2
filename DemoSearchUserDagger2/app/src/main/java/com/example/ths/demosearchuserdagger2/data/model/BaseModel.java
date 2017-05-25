package com.example.ths.demosearchuserdagger2.data.model;

import com.google.gson.Gson;

/**
 * Created by ths on 23/05/2017.
 */

public abstract class BaseModel implements Cloneable {
    public BaseModel clone() throws CloneNotSupportedException {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this), this.getClass());
    }
}
