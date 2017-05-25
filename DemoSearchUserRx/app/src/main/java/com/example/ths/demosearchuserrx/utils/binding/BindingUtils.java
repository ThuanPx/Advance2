package com.example.ths.demosearchuserrx.utils.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.example.ths.demosearchuserrx.R;
import com.squareup.picasso.Picasso;

/**
 * Created by ths on 22/05/2017.
 */

public class BindingUtils {
    private BindingUtils() {
    }
    @BindingAdapter("recyclerAdapter")
    public static void setAdapterRecyclerView(RecyclerView recyclerView ,RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }
    @BindingAdapter("srcImage")
    public static void  setImageUrl(ImageView view,String url){
        Picasso.with(view.getContext()).load(url).placeholder(R.drawable.androidify).into(view);
    }
}
