package com.example.myapplication.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.newsapp.GlobalNewsActivity;
import com.example.myapplication.newsapp.R;
import com.example.myapplication.newsapp.model.gridModel.gridModel;

import java.util.List;

/**
 * Created by Yara on 28-Mar-18.
 */

public class gridAdapter extends RecyclerView.Adapter<gridVH> {
    Context mcontext;
    List<gridModel> list;

    public gridAdapter(Context mcontext, List<gridModel> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @Override
    public gridVH onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext= parent.getContext();
        View view = LayoutInflater.from(mcontext).inflate(R.layout.grid_item, parent, false);
        return new gridVH(view);
    }

    @Override
    public void onBindViewHolder(gridVH holder, int position) {
        final gridModel model =list.get(position);
        holder.grid_text.setText(model.getNewspaper_name());
        holder.grid_image.setImageResource(model.getNewspaper_image());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gintent = new Intent(mcontext, GlobalNewsActivity.class);
                gintent.putExtra("source",model.getNewspaper_source());
                mcontext.startActivity(gintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
