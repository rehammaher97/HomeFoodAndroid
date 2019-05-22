package com.example.homefood.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.homefood.R;
import com.example.homefood.fragments.ScreenSlidePageFragment;

public class BestDealsPagerAdapter extends FragmentStatePagerAdapter {

    private int num_pages;
    private Context context;

    public BestDealsPagerAdapter(FragmentManager fm, Context context, int num_pages){
        super(fm);
        this.context = context;
        this.num_pages = num_pages;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return ScreenSlidePageFragment.newInstance(context.getString(R.string.pic_one));
        }else if(position == 1){
            return ScreenSlidePageFragment.newInstance(context.getString(R.string.pic_two));
        }else if(position == 2){
            return ScreenSlidePageFragment.newInstance(context.getString(R.string.pic_three));
        }else{
            return ScreenSlidePageFragment.newInstance(context.getString(R.string.pic_four));
        }

    }

    @Override
    public int getCount() {
        return num_pages;
    }

}