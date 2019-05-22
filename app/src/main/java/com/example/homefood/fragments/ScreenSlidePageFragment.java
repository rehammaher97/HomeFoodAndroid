package com.example.homefood.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.homefood.R;

public class ScreenSlidePageFragment extends Fragment {

    private static final String PHOTO_NAME = "PHOTO_NAME";
    private String mPhotoName;

    public ScreenSlidePageFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPhotoName = getArguments().getString(PHOTO_NAME);
        }

    }

    public static ScreenSlidePageFragment newInstance(String param1) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(PHOTO_NAME, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        ImageView imageView = rootView.findViewById(R.id.imageView);
        if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_one))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.a_1));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_two))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.a_2));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_three))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.a_3));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_four))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.a_4));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_b_one))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_1));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_b_two))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_2));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_b_three))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_3));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_b_four))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_4));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_b_five))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_5));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_b_six))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_6));
        }else if(mPhotoName.equalsIgnoreCase(getString(R.string.pic_b_seven))){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_7));
        }else{
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.b_8));
        }

        return rootView;
    }
}
