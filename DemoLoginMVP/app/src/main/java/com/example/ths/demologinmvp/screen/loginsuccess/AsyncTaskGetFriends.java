package com.example.ths.demologinmvp.screen.loginsuccess;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ths.demologinmvp.data.FriendsList;
import com.example.ths.demologinmvp.data.FriendsListData;
import com.example.ths.demologinmvp.screen.loginsuccess.GetFriendComplete;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 16/05/2017.
 */

public class AsyncTaskGetFriends extends AsyncTask<String, Void, List<FriendsList>>  {
    List<FriendsList> mFriendsLists = new ArrayList<>();
    private GetFriendComplete mGetFriendComplete;

    public void setmGetFriendComplete(GetFriendComplete mGetFriendComplete) {
        this.mGetFriendComplete = mGetFriendComplete;
    }


    @Override
    protected List<FriendsList> doInBackground(String... params) {

        String link = params[0];
        InputStreamReader reader;
        try {
            reader = readURL(link);

            for (int i = 0; i <= 5; i++) {
                FriendsListData mListData = new Gson().fromJson(reader, FriendsListData.class);
                mFriendsLists.addAll(mListData.getFriends());

                reader = readURL(mListData.getPaging().getNext());
            }

//            do{
//                mListData = new Gson().fromJson(reader, FriendsListData.class);
//                mFriendsLists.addAll(mListData.getFriends());
//                reader=readURL(mListData.getPaging().getNext());
//            }while(!TextUtils.isEmpty(mListData.getPaging().getNext()));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return mFriendsLists;
    }

    @Override
    protected void onPostExecute(List<FriendsList> friendsLists) {
        super.onPostExecute(friendsLists);
        Log.d("asdsad",friendsLists.size()+"");
        mGetFriendComplete.getSuccess(friendsLists);

    }

    public InputStreamReader readURL(String s) throws Exception {
        URL url = new URL(s);
        InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");

        return reader;
    }
}
