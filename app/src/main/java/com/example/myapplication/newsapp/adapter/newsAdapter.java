package com.example.myapplication.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.newsapp.MainActivity;
import com.example.myapplication.newsapp.R;
import com.example.myapplication.newsapp.model.data.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Yara on 20-Mar-18.
 */

public class newsAdapter extends  RecyclerView.Adapter<newsVH> {
    Context context;
    List<Article>list;

    public newsAdapter(Context context, List<Article> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public newsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new newsVH(view);
    }

    @Override
    public void onBindViewHolder(newsVH holder, int position) {
        final Article article=list.get(position);
        holder.title.setText(article.getTitle());
        holder.name.setText(article.getSource().getName());
        holder.details.setText(article.getDescription());
        holder.publishedAt.setText(article.getPublishedAt());
        Picasso.with(context).load(article.getUrlToImage()).into(holder.newsImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, MainActivity.class);
                intent.putExtra("url",article.getUrl());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
