package com.example.ths.fragment_tablayout_viewpage.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ths.fragment_tablayout_viewpage.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentTwo extends Fragment {


    public BlankFragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment_two, container, false);
    }

}
