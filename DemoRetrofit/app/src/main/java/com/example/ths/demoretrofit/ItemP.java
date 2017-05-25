package com.example.ths.demoretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 12/05/2017.
 */

public class ItemP {
    @SerializedName("page")
    private Integer page;
    @SerializedName("per_page")
    private Integer perPage;
    @SerializedName("total")
    private Integer total;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("data")
    private List<ItemA> data;

    public ItemP() {
    }

    public List<ItemA> getData() {
        return data;
    }

    public class ItemA {
        @SerializedName("id")
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public ItemA(int id) {
            this.id = id;
        }
    }

}

