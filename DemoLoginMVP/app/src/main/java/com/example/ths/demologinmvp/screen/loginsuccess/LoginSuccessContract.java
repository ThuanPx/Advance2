package com.example.ths.demologinmvp.screen.loginsuccess;

import com.example.ths.demologinmvp.data.FriendsList;
import com.example.ths.demologinmvp.screen.BasePresenter;

import java.util.List;

/**
 * Created by ths on 16/05/2017.
 */

public interface LoginSuccessContract {
    interface View {
        void getFriendsSuccess(List<FriendsList> friendsLists);
    }

    interface Presenter extends BasePresenter<View>{
        void getFriendsFb(String link);
    }
}
