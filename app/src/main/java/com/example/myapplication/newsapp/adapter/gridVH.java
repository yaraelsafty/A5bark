package com.example.myapplication.newsapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.newsapp.R;

/**
 * Created by Yara on 28-Mar-18.
 */

public class gridVH extends RecyclerView.ViewHolder  {
    ImageView grid_image;
    TextView grid_text;

    public gridVH(View itemView) {
        super(itemView);
        grid_image=itemView.findViewById(R.id.iv_newspaper);
        grid_text=itemView.findViewById(R.id.newspaper_name);
    }
}
