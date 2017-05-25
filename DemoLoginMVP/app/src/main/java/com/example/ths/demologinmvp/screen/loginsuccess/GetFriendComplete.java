package com.example.ths.demologinmvp.screen.loginsuccess;

import com.example.ths.demologinmvp.data.FriendsList;

import java.util.List;

/**
 * Created by ths on 16/05/2017.
 */

public interface GetFriendComplete {
    void  getSuccess(List<FriendsList> friendsLists);
}
