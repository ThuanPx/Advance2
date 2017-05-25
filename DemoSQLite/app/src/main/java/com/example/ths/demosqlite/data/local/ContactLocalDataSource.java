package com.example.ths.demosqlite.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ths.demosqlite.data.ContactDataSource;
import com.example.ths.demosqlite.data.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ths on 10/05/2017.
 */

public class ContactLocalDataSource extends DatabaseHelper implements ContactDataSource {
    private static ContactDataSource source;

    public static ContactDataSource getInstance(Context context) {
        if (source == null) {
            source = new ContactLocalDataSource(context);
        }
        return source;
    }

    public ContactLocalDataSource(Context context) {
        super(context);
    }

    @Override
    public boolean insertContact(Contact contact) {
        if (contact == null) return false;
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(ContactContract.ContactEntry.TABLE_NAME, null, contact.getContentValues());
        return result != -1;

    }

    @Override
    public List<Contact> getAllContact() {
        SQLiteDatabase db = getReadableDatabase();
        List<Contact> contactList = new ArrayList<>();
        String[] projection = {
                ContactContract.ContactEntry.COLUMN_NAME, ContactContract.ContactEntry.COLUMN_PHONE, ContactContract.ContactEntry.COLUMN_ADD,
        };

        Cursor cursor = db.query(ContactContract.ContactEntry.TABLE_NAME, projection, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            contactList = new ArrayList<>();
            do {
                contactList.add(new Contact(cursor));
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return contactList;
    }


    @Override
    public List<Contact> getContactByName(String name) {
        SQLiteDatabase db = getReadableDatabase();
        List<Contact> contactList = new ArrayList<>();
        String[] projection = {
                ContactContract.ContactEntry.COLUMN_NAME, ContactContract.ContactEntry.COLUMN_PHONE, ContactContract.ContactEntry.COLUMN_ADD,
        };
        String whereClause = ContactContract.ContactEntry.COLUMN_NAME + " LIKE ?";
        String[] whereArgs = {name};
        Cursor cursor = db.query(ContactContract.ContactEntry.TABLE_NAME, projection, whereClause, whereArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            contactList = new ArrayList<>();
            do {
                contactList.add(new Contact(cursor));
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return contactList;
    }

    @Override
    public boolean updateContact(Contact contact) {
        return false;
    }
}
