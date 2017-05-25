package com.example.ths.demosearchuserdagger2.data.source;

import com.example.ths.demosearchuserdagger2.data.model.User;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ths on 23/05/2017.
 */

public class UserRepositoryImpl implements UserRepository {
    private UserDataSource.RemoteDataSource mRemoteDataSource;

    public UserRepositoryImpl(UserDataSource.RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<User>> searchUsers(int limit, String keyWord) {
        return mRemoteDataSource.searchUsers(limit,keyWord);
    }
}
