package com.example.ths.demosearchuserdagger2.data.source.remote;

import android.util.Log;
import com.example.ths.demosearchuserdagger2.data.model.ListUser;
import com.example.ths.demosearchuserdagger2.data.model.User;
import com.example.ths.demosearchuserdagger2.data.source.UserDataSource;
import com.example.ths.demosearchuserdagger2.data.source.remote.api.service.GitHubApi;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by ths on 23/05/2017.
 */

public class UserRemoteDataSource extends BaseRemoteDataSource implements UserDataSource.RemoteDataSource {
    public UserRemoteDataSource(GitHubApi gitHubApi) {
        super(gitHubApi);
    }

    @Override
        public Observable<List<User>> searchUsers(int limit, String keyWord) {
            return mGitHubApi.searchUser(limit,keyWord).flatMap(new Function<ListUser, Observable<List<User>>>() {
                @Override
                public Observable<List<User>> apply(@NonNull ListUser listUser) throws Exception {
                        if(listUser!=null){
//                            Log.d("test ok","ok"+ listUser);
                            return Observable.just(listUser.getUserList());
                        }
                    return Observable.error(new NullPointerException());
                }
            });
        }

}
