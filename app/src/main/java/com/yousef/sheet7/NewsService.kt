package com.yousef.sheet7

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsService {
    companion object{
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}