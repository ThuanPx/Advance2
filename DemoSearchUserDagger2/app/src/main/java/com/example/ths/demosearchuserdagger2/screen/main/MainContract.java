package com.example.ths.demosearchuserdagger2.screen.main;

import com.example.ths.demosearchuserdagger2.data.model.ListUser;
import com.example.ths.demosearchuserdagger2.data.model.User;
import com.example.ths.demosearchuserdagger2.utils.rx.BaseSchedulerProvider;
import java.util.List;

/**
 * Created by ths on 23/05/2017.
 */

public interface MainContract {
    interface View {
        void onSearchSuccess(List<User> users);
        void onSearchError(Throwable throwable);
    }
    interface Presenter {
        void setSchedulerProvider(BaseSchedulerProvider mSchedulerProvider);
        void searchUsers(int limit, String keyWord);
        void onStop();
    }
}
