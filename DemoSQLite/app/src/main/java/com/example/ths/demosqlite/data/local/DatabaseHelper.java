package com.example.ths.demosqlite.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ths on 10/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int D_VERSION = 1;
    public static final String DATABASE_NAME = "contact2.db";
    private static final String SQL_CREATE_CONTACTS = "CREATE TABLE "
            + ContactContract.ContactEntry.TABLE_NAME
            + "("
            + ContactContract.ContactEntry.COLUMN_NAME
            + " TEXT ,"
            + ContactContract.ContactEntry.COLUMN_PHONE
            + " TEXT ,"
            + ContactContract.ContactEntry.COLUMN_ADD
            + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, D_VERSION);
    }
    private static final String SQL_DELETE_CONTACTS =
            "DROP TABLE IF EXISTS " + ContactContract.ContactEntry.TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CONTACTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_CONTACTS);
        db.execSQL(SQL_CREATE_CONTACTS);
    }
}
