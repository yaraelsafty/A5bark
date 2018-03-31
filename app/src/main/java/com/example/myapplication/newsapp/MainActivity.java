package com.example.myapplication.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.newsapp.fragments.CategoryFragment;
import com.example.myapplication.newsapp.fragments.TopheadlinesFragment;
import com.example.myapplication.newsapp.fragments.WebFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat(" dd MMMM  yyyy");
        SimpleDateFormat dformat = new SimpleDateFormat("EEEE");
        String strDate =  mdformat.format(cal.getTime());
        String dayname =  dformat.format(cal.getTime());

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if (url!=null){
            WebFragment webFragment =new WebFragment().newInstance(url);
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,webFragment ).commit();

        }
        else {
            TopheadlinesFragment topheadlinesFragment =new TopheadlinesFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,topheadlinesFragment ).commit();
        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
       TextView date_month_year = (TextView) headerView.findViewById(R.id.date_month_year);
        date_month_year.setText(strDate);
        TextView date_day = (TextView) headerView.findViewById(R.id.date_day);
        date_day.setText(dayname);



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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_TopHeadLines) {
            TopheadlinesFragment topheadlinesFragment =new TopheadlinesFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,topheadlinesFragment ).commit();


        } else if (id == R.id.nav_Business) {
            CategoryFragment categoryFragment=new CategoryFragment().newInstance("eg","business");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,categoryFragment ).commit();

        } else if (id == R.id.nav_Entertainment) {
            CategoryFragment categoryFragment=new CategoryFragment().newInstance("eg","entertainment");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,categoryFragment ).commit();

        } else if (id == R.id.nav_Health) {
            CategoryFragment categoryFragment=new CategoryFragment().newInstance("eg","health");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,categoryFragment ).commit();

        } else if (id == R.id.nav_Science) {
            CategoryFragment categoryFragment=new CategoryFragment().newInstance("eg","science");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,categoryFragment ).commit();

        } else if (id == R.id.nav_Technology) {
            CategoryFragment categoryFragment=new CategoryFragment().newInstance("eg","technology");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,categoryFragment ).commit();

        }else if (id == R.id.nav_Sport){
            CategoryFragment categoryFragment=new CategoryFragment().newInstance("eg","sports");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame,categoryFragment ).commit();
        }
        else if (id==R.id.nav_general){
            Intent i =new Intent(this,GlobalNewsActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
