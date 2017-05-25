package com.example.ths.demologinmvp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ths on 15/05/2017.
 */

public class FriendsList implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("picture")
    private picture mPicture;

    protected FriendsList(Parcel in) {
        name = in.readString();
    }

    public static final Creator<FriendsList> CREATOR = new Creator<FriendsList>() {
        @Override
        public FriendsList createFromParcel(Parcel in) {
            return new FriendsList(in);
        }

        @Override
        public FriendsList[] newArray(int size) {
            return new FriendsList[size];
        }
    };

    public String getName() {
        return name;
    }

    public picture getmPicture() {
        return mPicture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setmPicture(picture mPicture) {
        this.mPicture = mPicture;
    }

    public FriendsList() {
    }

    public FriendsList(String name, picture mPicture) {
        this.name = name;
        this.mPicture = mPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(mPicture.getmDataUrl().getImageUrl());
    }

    public class picture implements Parcelable {
        @SerializedName("data")
        private dataUrl mDataUrl;

        protected picture(Parcel in) {
            mDataUrl = in.readParcelable(dataUrl.class.getClassLoader());
        }

        public final Creator<picture> CREATOR = new Creator<picture>() {
            @Override
            public picture createFromParcel(Parcel in) {
                return new picture(in);
            }

            @Override
            public picture[] newArray(int size) {
                return new picture[size];
            }
        };

        public dataUrl getmDataUrl() {
            return mDataUrl;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(mDataUrl, flags);
        }

        public class dataUrl implements Parcelable {
            @SerializedName("url")
            private String imageUrl;

            protected dataUrl(Parcel in) {
                imageUrl = in.readString();
            }

            public final Creator<dataUrl> CREATOR = new Creator<dataUrl>() {
                @Override
                public dataUrl createFromParcel(Parcel in) {
                    return new dataUrl(in);
                }

                @Override
                public dataUrl[] newArray(int size) {
                    return new dataUrl[size];
                }
            };

            public String getImageUrl() {
                return imageUrl;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(imageUrl);
            }
        }
    }
}
