package com.example.myapplication.newsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.newsapp.R;
import com.example.myapplication.newsapp.adapter.newsAdapter;
import com.example.myapplication.newsapp.model.data.Article;
import com.example.myapplication.newsapp.model.data.News;
import com.example.myapplication.newsapp.model.network.ApiClient;
import com.example.myapplication.newsapp.model.network.NewsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    public String API_Key ="a8d4f0a395d7431e8da1b681346f23d2";
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COUNTRY = "country";
    private static final String ARG_CATEGORY= "category";

    // TODO: Rename and change types of parameters
    private String country;
    private String category;


    public CategoryFragment() {
        // Required empty public constructor
    }


    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COUNTRY, param1);
        args.putString(ARG_CATEGORY, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            country = getArguments().getString(ARG_COUNTRY);
            category = getArguments().getString(ARG_CATEGORY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.news, container, false);
        recyclerView=view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        swipeRefreshLayout=view.findViewById(R.id.sw);
        getdata();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();
            }
        });

        return view;
    }
    private void getdata(){
        NewsService apiService =
                ApiClient.getClient().create(NewsService.class);
        Call<News> call = apiService.getNewsCategory(country,category,API_Key);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                List<Article> news=response.body().getArticles();
                recyclerView.setAdapter(new newsAdapter(getActivity(),news));
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }

}
