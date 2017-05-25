package com.example.ths.demosqlite.screen.main;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ths.demosqlite.R;
import com.example.ths.demosqlite.data.ContactDataSource;
import com.example.ths.demosqlite.data.ContactRepository;
import com.example.ths.demosqlite.data.model.Contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private List<Contact> mContactList;
    private ContactDataSource mRepository;
    private RecyclerView rv;
    private ContactAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        initView();


    }

    private void getData() {
        mRepository = ContactRepository.getInstance(this);
        mContactList = mRepository.getAllContact();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        mAdapter = new ContactAdapter(mContactList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);

//        mAdapter2 = new ContactAdapter2(mContactList, this);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        rv.setLayoutManager(linearLayoutManager);
//        rv.setAdapter(mAdapter2);
//        rv.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemAdd) {
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            Log.d("test", "time :");
            Contact contact = new Contact("Contact " + randomNumber, "01234 56 " + randomNumber,
                    "HN +" + randomNumber);
            insertContact(contact);
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertContact(final Contact contact) {
        if (mRepository.insertContact(contact)) {
            mContactList.add(0, contact);
            mAdapter.notifyItemInserted(0);
            rv.scrollToPosition(0);
        } else {
            Snackbar.make(rv, "Error to insert contact", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            insertContact(contact);
                        }
                    })
                    .show();
        }
    }
}
