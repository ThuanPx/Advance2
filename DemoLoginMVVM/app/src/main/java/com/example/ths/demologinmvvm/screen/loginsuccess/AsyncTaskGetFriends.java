package com.example.ths.demologinmvvm.screen.loginsuccess;

import android.os.AsyncTask;
import com.example.ths.demologinmvvm.data.model.ObjectData;
import com.example.ths.demologinmvvm.data.model.data;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 17/05/2017.
 */

public class AsyncTaskGetFriends extends AsyncTask<String, Void, List<data>> {
    private List<data> mDataList;
    private GetFriendsListener mGetFriendsListener;

    public void setGetFriendsListener(GetFriendsListener getFriendsListener) {
        mGetFriendsListener = getFriendsListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mDataList = new ArrayList<>();
//        mGetFriendsListener.showDialog();
    }

    @Override
    protected List<data> doInBackground(String... params) {
        InputStreamReader reader;
        try {
            reader = readURL(params[0]);
//            for (int i = 0; i < 4; i++) {
                ObjectData mObjectData = new Gson().fromJson(reader, ObjectData.class);
                mDataList.addAll(mObjectData.getData());
//                reader = readURL(mObjectData.getPaging().getNext());
                mGetFriendsListener.getPageNext(mObjectData.getPaging().getNext());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDataList;
    }

    @Override
    protected void onPostExecute(List<data> datas) {
        super.onPostExecute(datas);
        mGetFriendsListener.getFriendsSuccess(mDataList);
     //   mGetFriendsListener.hideDialog();
    }

    private InputStreamReader readURL(String s) throws Exception {
        URL url = new URL(s);
        InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");

        return reader;
    }
}
