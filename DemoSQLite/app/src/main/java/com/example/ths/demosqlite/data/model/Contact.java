package com.example.ths.demosqlite.data.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.ths.demosqlite.data.local.ContactContract;

/**
 * Created by ths on 10/05/2017.
 */

public class Contact {
    private String name_;
    private String phone_;
    private String add_;

    public Contact(String name, String phone, String add) {
        this.name_ = name;
        this.phone_ = phone;
        this.add_ = add;
    }

    public Contact() {
    }

    public String getName() {

        return name_;
    }

    public void setName(String name) {
        this.name_ = name;
    }

    public String getPhone() {
        return phone_;
    }

    public void setPhone(String phone) {
        this.phone_ = phone;
    }

    public String getAdd() {
        return add_;
    }

    public void setAdd(String add) {
        this.add_ = add;
    }

    public Contact(Cursor cursor) {
        name_ = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_NAME));
        phone_ = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_PHONE));
        add_ = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.COLUMN_ADD));
    }
    public ContentValues getContentValues(){
        ContentValues contentValues =new ContentValues();
        if(name_ !=null){
            contentValues.put(ContactContract.ContactEntry.COLUMN_NAME,name_);
        }
        if(phone_ !=null){
            contentValues.put(ContactContract.ContactEntry.COLUMN_PHONE,phone_);
        }
        if(add_ !=null){
            contentValues.put(ContactContract.ContactEntry.COLUMN_ADD,add_);
        }
        return contentValues;
    }
}
