package com.example.ths.fragment_tablayout_viewpage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ths.fragment_tablayout_viewpage.fragment.BlankFragmentOne;
import com.example.ths.fragment_tablayout_viewpage.fragment.BlankFragmentThree;
import com.example.ths.fragment_tablayout_viewpage.fragment.BlankFragmentTwo;

/**
 * Created by ths on 08/05/2017.
 */

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "One";
                break;
            case 1:
                title = "Two";
                break;
            case 2:
                title = "Three";
                break;
        }
        return title;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment =null;
        switch (position){
            case 0:
                fragment = new BlankFragmentOne();
                break;
            case 1:
                fragment = new BlankFragmentTwo();
                break;
            case 2:
                fragment = new BlankFragmentThree();
                break;
        }
        return fragment ;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
