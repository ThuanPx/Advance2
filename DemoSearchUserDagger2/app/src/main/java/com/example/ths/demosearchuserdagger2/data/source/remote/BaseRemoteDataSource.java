package com.example.ths.demosearchuserdagger2.data.source.remote;

import com.example.ths.demosearchuserdagger2.data.source.remote.api.service.GitHubApi;

/**
 * Created by ths on 23/05/2017.
 */

public abstract class BaseRemoteDataSource {
    GitHubApi mGitHubApi;

    public BaseRemoteDataSource(GitHubApi gitHubApi) {
        mGitHubApi = gitHubApi;
    }
}
