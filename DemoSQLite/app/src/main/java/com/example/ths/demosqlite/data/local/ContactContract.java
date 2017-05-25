package com.example.ths.demosqlite.data.local;

import android.provider.BaseColumns;

/**
 * Created by ths on 10/05/2017.
 */

public class ContactContract {
    public ContactContract() {
    }
    public static class ContactEntry implements BaseColumns{
        public static final String TABLE_NAME ="tbl_contact";
        public static final String COLUMN_NAME="_name";
        public static final String COLUMN_PHONE="_phone";
        public static final String COLUMN_ADD="_address";
    }
}