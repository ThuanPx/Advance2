package com.example.ths.demoretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by ths on 11/05/2017.
 */

public interface ProductService {
    @GET("/api/users?")
    Call<MultiProducts> listProduct(@Query("page") String page);
    @GET("/api/users?page=2")
    Call<ItemP> getItem();
    @FormUrlEncoded
    @POST("/api/users?")
    Call<User> postUser(@Field("name") String name,@Field("job") String job);
    @POST("/api/users")
    Call<User> postUser2(@Body User user);
}
