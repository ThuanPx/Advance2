package com.example.ths.demologinmvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ths on 17/05/2017.
 */
public class data implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("picture")
    private picture mPicture ;

    public data(String name, picture picture) {
        this.name = name;
        mPicture = picture;
    }

    public data() {

    }

    protected data(Parcel in) {
        name = in.readString();
        mPicture = in.readParcelable(picture.class.getClassLoader());
    }

    public static final Creator<data> CREATOR = new Creator<data>() {
        @Override
        public data createFromParcel(Parcel in) {
            return new data(in);
        }

        @Override
        public data[] newArray(int size) {
            return new data[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public picture getPicture() {
        return mPicture;
    }

    public void setPicture(picture picture) {
        mPicture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(mPicture, flags);
    }
}
