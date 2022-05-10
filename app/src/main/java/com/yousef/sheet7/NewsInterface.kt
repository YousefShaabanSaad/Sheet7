package com.yousef.sheet7

import com.yousef.sheet7.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("top-headlines")
    fun getNews(
        @Query("apiKey") apiKey:String,
        @Query("country") country:String
    ):Call<News>
}
