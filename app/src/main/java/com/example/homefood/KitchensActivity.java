package com.example.homefood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.homefood.adapters.KitchensAdapter;

public class KitchensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchens);

        String[] kitchenNames ={"Nona Kitchen","El Haga Zenaib Kitchen", "Gana Kitchen","Sophia Kitchen"};

        Integer[] imgid={
                R.drawable.k_1,R.drawable.k_2,
                R.drawable.k_3,R.drawable.k_4
        };

        KitchensAdapter adapter=new KitchensAdapter(this, kitchenNames, imgid);
        ListView list=(ListView)findViewById(R.id.kitchens_list);
        list.setAdapter(adapter);
    }
}
