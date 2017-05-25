package com.example.ths.demoretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 11/05/2017.
 */

public class MultiProducts {

    @SerializedName("page")
    private Integer page;
    @SerializedName("per_page")
    private Integer perPage;
    @SerializedName("total")
    private Integer total;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("data")
    private List<Products> data = new ArrayList();

    public MultiProducts() {
    }

    public List<Products> getData() {
        return data;
    }

    public class Products {

        @SerializedName("id")
        private Integer id;
        @SerializedName("first_name")
        private String first_name;
        @SerializedName("last_name")
        private String last_name;
        @SerializedName("avatar")
        private String avatar;

        public Products(Integer id, String first_name, String last_name, String avatar) {
            this.id = id;
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar = avatar;
        }

        public Products() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }

}
