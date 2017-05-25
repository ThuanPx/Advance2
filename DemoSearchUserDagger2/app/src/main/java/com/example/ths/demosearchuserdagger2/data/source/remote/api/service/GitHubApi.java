package com.example.ths.demosearchuserdagger2.data.source.remote.api.service;

import com.example.ths.demosearchuserdagger2.data.model.ListUser;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ths on 23/05/2017.
 */

public interface GitHubApi {
    @GET("/search/users")
    Observable<ListUser> searchUser(@Query("per_page") int limit,
            @Query("q") String searchTerm);
}
