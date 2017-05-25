package com.example.ths.demosqlite.screen.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ths.demosqlite.R;
import com.example.ths.demosqlite.data.model.Contact;

import java.util.List;

/**
 * Created by ths on 10/05/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<Contact> contactList;
    private LayoutInflater mLayoutInflater;

    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = mLayoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(contactList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactList != null ? contactList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvPhone, tvAdd;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvContact);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
            tvAdd = (TextView) itemView.findViewById(R.id.tv3);
        }

        public void bindData(Contact contact) {
            if (contact == null) return;
            tvName.setText(contact.getName());
            tvPhone.setText(contact.getPhone());
            tvAdd.setText(contact.getAdd());
        }
    }

}
