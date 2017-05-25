package com.example.ths.demosqlite.screen.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class ContactAdapter2 extends RecyclerView.Adapter<ContactAdapter2.ViewHolder2> {
    private List<Contact> mContactList;
    private Context context;
    private LayoutInflater layoutInflater;

    public ContactAdapter2(List<Contact> mContactList, Context context) {
        this.mContactList = mContactList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder2 holder, int position) {
        Contact contact = mContactList.get(position);
        holder.tvName.setText(contact.getName());
    }
    public void addContactss(Contact contact){
        mContactList.add(contact);
        notifyItemInserted(mContactList.size()-1);
    }
    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView tvName, tvPhone, tvAdd;

        public ViewHolder2(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvContact);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
            tvAdd = (TextView) itemView.findViewById(R.id.tv3);
        }
    }
}
