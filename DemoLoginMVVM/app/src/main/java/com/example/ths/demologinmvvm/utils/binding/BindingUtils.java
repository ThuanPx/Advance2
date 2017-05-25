package com.example.ths.demologinmvvm.utils.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.example.ths.demologinmvvm.R;
import com.squareup.picasso.Picasso;

/**
 * Created by ths on 18/05/2017.
 */

public final class BindingUtils  {
    private BindingUtils() {
    }

    @BindingAdapter("recyclerAdapter")
    public static void setAdapterRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter){

            recyclerView.setAdapter(adapter);
    }
    @BindingAdapter("android:srcUrl")
    public static void setImageUrl(ImageView view,String url){
        Picasso.with(view.getContext()).load(url).placeholder(R.drawable.androidify).into(view);
    }
}
