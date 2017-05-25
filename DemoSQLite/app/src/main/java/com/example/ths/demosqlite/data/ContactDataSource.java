package com.example.ths.demosqlite.data;

import com.example.ths.demosqlite.data.model.Contact;

import java.util.List;

/**
 * Created by ths on 10/05/2017.
 */

public interface ContactDataSource {
    boolean insertContact(Contact contact);

    List<Contact> getAllContact();

    List<Contact> getContactByName(String name);

    boolean updateContact(Contact contact);


}
