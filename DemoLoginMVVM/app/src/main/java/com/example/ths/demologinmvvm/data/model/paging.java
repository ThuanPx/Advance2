package com.example.ths.demologinmvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ths on 17/05/2017.
 */

public class paging implements Parcelable {
    @SerializedName("next")
    private String next;

    protected paging(Parcel in) {
        next = in.readString();
    }

    public static final Creator<paging> CREATOR = new Creator<paging>() {
        @Override
        public paging createFromParcel(Parcel in) {
            return new paging(in);
        }

        @Override
        public paging[] newArray(int size) {
            return new paging[size];
        }
    };

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public paging() {
    }

    public paging(String next) {

        this.next = next;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(next);
    }
}
