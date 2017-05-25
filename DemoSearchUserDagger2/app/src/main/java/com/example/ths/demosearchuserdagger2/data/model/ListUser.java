package com.example.ths.demosearchuserdagger2.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ths on 23/05/2017.
 */

public class ListUser extends BaseModel implements Parcelable {
    private int total_count;
    private boolean incomplete_results;
    @SerializedName("items")
    private List<User> mUserList;

    protected ListUser(Parcel in) {
        total_count = in.readInt();
        incomplete_results = in.readByte() != 0;
        mUserList = in.createTypedArrayList(User.CREATOR);
    }

    public static final Parcelable.Creator<ListUser> CREATOR = new Parcelable.Creator<ListUser>() {
        @Override
        public ListUser createFromParcel(Parcel in) {
            return new ListUser(in);
        }

        @Override
        public ListUser[] newArray(int size) {
            return new ListUser[size];
        }
    };

    public List<User> getUserList() {
        return mUserList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(total_count);
        dest.writeByte((byte) (incomplete_results ? 1 : 0));
        dest.writeTypedList(mUserList);
    }
}


