package com.example.ths.demosearchuserrx.data.source.remote.api.service;

import com.example.ths.demosearchuserrx.data.model.ListUser;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ths on 19/05/2017.
 */

public interface GitHubApi {
    @GET("search/users")
    Observable<ListUser> searchUserGitHub(@Query("q") String search,@Query("per_page") int limit);
}
