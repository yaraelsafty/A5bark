package com.example.myapplication.newsapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.newsapp.adapter.gridAdapter;
import com.example.myapplication.newsapp.fragments.GlobalPoliticalNewsFragment;
import com.example.myapplication.newsapp.fragments.WebFragment;
import com.example.myapplication.newsapp.model.gridModel.gridModel;

import java.util.ArrayList;
import java.util.List;

public class GlobalNewsActivity extends AppCompatActivity {
    List<gridModel> gridModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_news);



        Intent intent=getIntent();
        String source=intent.getStringExtra("source");
        if(source!=null){
            GlobalPoliticalNewsFragment globalPoliticalNewsFragment =new GlobalPoliticalNewsFragment().newInstance(source);
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.global_frame,globalPoliticalNewsFragment ).commit();
        }else{
            RecyclerView recyclerView= (RecyclerView) findViewById(R.id.rv_global_news);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(new GridLayoutManager(this,3));
            recyclerView.setAdapter(new gridAdapter(this,allnewspaper()));

        }



    }

    private List<gridModel> allnewspaper() {
        gridModelList=new ArrayList<>();
        gridModelList.add(new gridModel(R.drawable.abc," ABC News","abc-news"));
        gridModelList.add(new gridModel(R.drawable.axios," Axios News","axios"));
        gridModelList.add(new gridModel(R.drawable.bbc," BBC News","bbc-news"));
        gridModelList.add(new gridModel(R.drawable.breitbart," Breitbart News","breitbart-news"));
        gridModelList.add(new gridModel(R.drawable.cbc,"CBC News","cbc-news"));
        gridModelList.add(new gridModel(R.drawable.cnn," CNN News","cnn"));
        gridModelList.add(new gridModel(R.drawable.google," Google News","google-news"));
        gridModelList.add(new gridModel(R.drawable.metro,"Metro  News","metro"));
        gridModelList.add(new gridModel(R.drawable.msnbc," MSNBC News","msnbc"));
        gridModelList.add(new gridModel(R.drawable.nbc," NBC News","nbc-news"));
        gridModelList.add(new gridModel(R.drawable.time,"Time","time"));
        gridModelList.add(new gridModel(R.drawable.usa_today,"USA Today","usa-today"));
        return gridModelList;
    }


}
