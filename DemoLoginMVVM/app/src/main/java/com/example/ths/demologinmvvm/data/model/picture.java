package com.example.ths.demologinmvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ths on 17/05/2017.
 */

public class picture implements Parcelable  {
    @SerializedName("data")
    private dataPicture mDataPicture;

    public picture() {
    }

    public picture(dataPicture dataPicture) {

        mDataPicture = dataPicture;
    }

    protected picture(Parcel in) {
        mDataPicture = in.readParcelable(dataPicture.class.getClassLoader());
    }

    public static final Creator<picture> CREATOR = new Creator<picture>() {
        @Override
        public picture createFromParcel(Parcel in) {
            return new picture(in);
        }

        @Override
        public picture[] newArray(int size) {
            return new picture[size];
        }
    };

    public dataPicture getDataPicture() {
        return mDataPicture;
    }

    public void setDataPicture(dataPicture dataPicture) {
        mDataPicture = dataPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mDataPicture, flags);
    }
}
