package com.example.homefood.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homefood.R;

public class KitchensAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] kitchenNames;
    private final Integer[] imagesIDs;

    public KitchensAdapter(Activity context, String[] kitchenNames, Integer[] imagesIDs) {
        super(context, R.layout.kitchen, kitchenNames);

        this.context = context;

        this.imagesIDs = imagesIDs;
        this.kitchenNames = kitchenNames;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.kitchen, null,true);

        TextView nameText = (TextView) rowView.findViewById(R.id.kitchen_name_txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.kitchen_img_view);


        imageView.setImageResource(imagesIDs[position]);
        nameText.setText(kitchenNames[position]);

        return rowView;
    }

    @Override
    public int getCount() {
        return kitchenNames.length;
    }
}