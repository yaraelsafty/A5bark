package com.example.myapplication.newsapp.model.network;

import com.example.myapplication.newsapp.model.data.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static android.R.attr.country;


/**
 * Created by Yara on 20-Mar-18.
 */

public interface NewsService {
    @GET("/v2/top-headlines")
    Call<News> getNews(@Query("country") String country ,@Query("apiKey") String API_KEY);

    @GET("/v2/top-headlines")
    Call<News> getNewsCategory(@Query("country") String country,@Query("category") String category,@Query("apiKey") String API_KEY);


   @GET("https://newsapi.org/v2/top-headlines")
   Call<News> getGlobalNews(@Query("sources") String sources ,@Query("apiKey") String API_KEY);

}
