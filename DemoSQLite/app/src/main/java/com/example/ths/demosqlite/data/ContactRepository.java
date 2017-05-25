package com.example.ths.demosqlite.data;

import android.content.Context;
import android.view.View;

import com.example.ths.demosqlite.data.local.ContactLocalDataSource;
import com.example.ths.demosqlite.data.model.Contact;

import java.util.List;

/**
 * Created by ths on 10/05/2017.
 */

public class ContactRepository implements ContactDataSource {
    private static ContactRepository mContactRepository;
    private ContactDataSource mLocalDataSource;

    public static ContactRepository getInstance(Context context) {
        if (mContactRepository == null) {
            mContactRepository = new ContactRepository(ContactLocalDataSource.getInstance(context));
        }
        return mContactRepository;
    }

    public ContactRepository(ContactDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    @Override
    public boolean insertContact(Contact contact) {
        return mLocalDataSource.insertContact(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return mLocalDataSource.getAllContact();
    }

    @Override
    public List<Contact> getContactByName(String name) {
        return mLocalDataSource.getContactByName(name);
    }

    @Override
    public boolean updateContact(Contact contact) {
        return false;
    }
}
