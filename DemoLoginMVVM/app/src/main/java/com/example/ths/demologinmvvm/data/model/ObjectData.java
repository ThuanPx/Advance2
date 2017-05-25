package com.example.ths.demologinmvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ths on 17/05/2017.
 */

public class ObjectData implements Parcelable {
    @SerializedName("data")
    private List<data> mData;
    @SerializedName("paging")
    private paging mPaging;

    public ObjectData() {
    }

    public ObjectData(List<data> data, paging paging) {
        mData = data;
        mPaging = paging;
    }

    protected ObjectData(Parcel in) {
        mData = in.createTypedArrayList(data.CREATOR);
        mPaging = in.readParcelable(paging.class.getClassLoader());
    }

    public static final Creator<ObjectData> CREATOR = new Creator<ObjectData>() {
        @Override
        public ObjectData createFromParcel(Parcel in) {
            return new ObjectData(in);
        }

        @Override
        public ObjectData[] newArray(int size) {
            return new ObjectData[size];
        }
    };

    public List<data> getData() {
        return mData;
    }

    public void setData(List<data> data) {
        mData = data;
    }

    public paging getPaging() {
        return mPaging;
    }

    public void setPaging(paging paging) {
        mPaging = paging;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mData);
        dest.writeParcelable(mPaging, flags);
    }
}
