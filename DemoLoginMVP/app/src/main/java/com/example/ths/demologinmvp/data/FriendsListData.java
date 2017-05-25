package com.example.ths.demologinmvp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ths on 15/05/2017.
 */
public class FriendsListData implements Parcelable{
    private PagingEntity paging;
    @SerializedName("data")
    private List<FriendsList> friends;

    protected FriendsListData(Parcel in) {
        paging = in.readParcelable(PagingEntity.class.getClassLoader());
        friends = in.createTypedArrayList(FriendsList.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(paging, flags);
        dest.writeTypedList(friends);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FriendsListData> CREATOR = new Creator<FriendsListData>() {
        @Override
        public FriendsListData createFromParcel(Parcel in) {
            return new FriendsListData(in);
        }

        @Override
        public FriendsListData[] newArray(int size) {
            return new FriendsListData[size];
        }
    };

    public List<FriendsList> getFriends() {
        return friends;
    }


    public PagingEntity getPaging() {
        return paging;
    }

    public void setPaging(PagingEntity paging) {
        this.paging = paging;
    }

    public void setFriends(List<FriendsList> friends) {
        this.friends = friends;
    }


    public FriendsListData(PagingEntity paging, List<FriendsList> friends) {
        this.paging = paging;
        this.friends = friends;
    }

    public FriendsListData() {
    }


    public static class PagingEntity implements Parcelable {

        private CursorsEntity cursors;
        private String next;
        private String previous;


        protected PagingEntity(Parcel in) {
            cursors = in.readParcelable(CursorsEntity.class.getClassLoader());
            next = in.readString();
            previous = in.readString();
        }

        public static final Creator<PagingEntity> CREATOR = new Creator<PagingEntity>() {
            @Override
            public PagingEntity createFromParcel(Parcel in) {
                return new PagingEntity(in);
            }

            @Override
            public PagingEntity[] newArray(int size) {
                return new PagingEntity[size];
            }
        };

        public String getPrevious() {
            return previous;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(previous);
            dest.writeString(next);
        }

        public static class CursorsEntity implements Parcelable {
            private String after;
            private String before;

            protected CursorsEntity(Parcel in) {
                after = in.readString();
                before = in.readString();
            }

            public static final Creator<CursorsEntity> CREATOR = new Creator<CursorsEntity>() {
                @Override
                public CursorsEntity createFromParcel(Parcel in) {
                    return new CursorsEntity(in);
                }

                @Override
                public CursorsEntity[] newArray(int size) {
                    return new CursorsEntity[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(after);
                dest.writeString(before);
            }
        }
    }
}
