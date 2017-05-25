package com.example.ths.demosearchuserdagger2.data.source;

import com.example.ths.demosearchuserdagger2.data.model.User;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ths on 23/05/2017.
 */

public interface UserDataSource {
    interface RemoteDataSource {
        Observable<List<User>> searchUsers(int limit, String keyWord);
    }
}
