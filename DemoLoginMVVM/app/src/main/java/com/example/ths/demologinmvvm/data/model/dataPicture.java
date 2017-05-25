package com.example.ths.demologinmvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ths on 17/05/2017.
 */

public class dataPicture implements Parcelable {
    @SerializedName("url")
    private String url;

    public dataPicture(String url) {
        this.url = url;
    }

    public dataPicture() {

    }

    protected dataPicture(Parcel in) {
        url = in.readString();
    }

    public static final Creator<dataPicture> CREATOR = new Creator<dataPicture>() {
        @Override
        public dataPicture createFromParcel(Parcel in) {
            return new dataPicture(in);
        }

        @Override
        public dataPicture[] newArray(int size) {
            return new dataPicture[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }
}
