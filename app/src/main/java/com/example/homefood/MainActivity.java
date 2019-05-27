package com.example.homefood;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homefood.adapters.BestDealsPagerAdapter;
import com.example.homefood.adapters.TrendingPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int BEST_DEALS_NUM_PAGES = 4;
    private static final int TRENDING_NUM_PAGES = 8;
    private static final String TAG = "MainActivity";

    private Spinner foodSpinner;
    private Spinner citySpinner;
    private Spinner regionSpinner;

    ViewPager trendingViewPager;
    PagerAdapter tendingAdapter;
    int page = 0;
    private Handler handler;
    private int delay = 2000; //milliseconds

    Runnable runnable = new Runnable() {
        public void run() {
            if (tendingAdapter.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            trendingViewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        // Instantiate a ViewPager and a PagerAdapter.
        ViewPager mPager = (ViewPager) findViewById(R.id.deals_view_pager);
        PagerAdapter pagerAdapter = new BestDealsPagerAdapter(getSupportFragmentManager(),this, BEST_DEALS_NUM_PAGES);
        mPager.setAdapter(pagerAdapter);

        trendingViewPager = (ViewPager) findViewById(R.id.trends_view_pager);
        tendingAdapter = new TrendingPageAdapter(getSupportFragmentManager(),this, TRENDING_NUM_PAGES);
        trendingViewPager.setAdapter(tendingAdapter);

        initializeSpinners();
        initializeSearchButton();

        handler = new Handler();

    }

    @Override
    public void onResume(){
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private void initializeSearchButton() {
        Button button = findViewById(R.id.search_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("button is clicked");
                String str = foodSpinner.getSelectedItem().toString() + ", "+citySpinner.getSelectedItem().toString()
                        +", " + regionSpinner.getSelectedItem().toString();

                System.out.println(str);

                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initializeSpinners() {
        foodSpinner = findViewById(R.id.food_spinner);
        List<String> list = new ArrayList<>();
        list.add("Tawagen");
        list.add("Mashwyat");
        list.add("");
        ArrayAdapter<String> foodSpinnerAdapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_item, list){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint("the food"); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;            // you don't display last item. It is used as hint.
            }
        };
        foodSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        foodSpinner.setAdapter(foodSpinnerAdapter);
        foodSpinner.setSelection(foodSpinnerAdapter.getCount());

        citySpinner = findViewById(R.id.city_spinner);
        List<String> list2 = new ArrayList<>();
        list2.add("Cairo");
        list2.add("Alexandria");
        list2.add("");
        ArrayAdapter<String> citySpinnerAdapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_item, list2){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint("the city"); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;            // you don't display last item. It is used as hint.
            }
        };
        citySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        citySpinner.setAdapter(citySpinnerAdapter);
        citySpinner.setSelection(citySpinner.getCount());


        regionSpinner = findViewById(R.id.region_spinner);
        List<String> list3 = new ArrayList<>();
        list3.add("Smouha");
        list3.add("Mandara");
        list3.add("");
        ArrayAdapter<String> regionSpinnerAdapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_item, list3){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint("the region"); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;            // you don't display last item. It is used as hint.
            }
        };
        regionSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        regionSpinner.setAdapter(regionSpinnerAdapter);
        regionSpinner.setSelection(regionSpinner.getCount());


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_kitchens) {
            Log.d(TAG, "onNavigationItemSelected: nav_kitchens");
            Intent intent = new Intent(this, KitchensActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
