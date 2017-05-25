package com.example.ths.demologinmvvm.screen.loginsuccess;

import com.example.ths.demologinmvvm.data.model.data;
import java.util.List;

/**
 * Created by ths on 18/05/2017.
 */

public interface GetFriendsListener  {
    void getFriendsSuccess(List<data> dataList);
    void getPageNext(String next);
    void showDialog();
    void hideDialog();
}
