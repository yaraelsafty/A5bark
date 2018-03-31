package com.example.myapplication.newsapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.newsapp.R;

/**
 * Created by Yara on 20-Mar-18.
 */

public class newsVH extends RecyclerView.ViewHolder  {
    TextView title,name,details,publishedAt;
    ImageView newsImage;

    public newsVH(View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.news_title);
        name=itemView.findViewById(R.id.name);
        details=itemView.findViewById(R.id.details);
        publishedAt=itemView.findViewById(R.id.PublishesAt);
        newsImage=itemView.findViewById(R.id.news_image);
    }
}
