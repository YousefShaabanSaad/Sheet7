package com.yousef.sheet7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yousef.sheet7.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData(){
        val getData=NewsService.getInstance().create(NewsInterface::class.java)
        getData.getNews("aeeb84e1ce46464aaf5f6655f5cae56a","eg")
            .enqueue(object : Callback<News?> {
                override fun onResponse(call: Call<News?>, response: Response<News?>) {
                    val newsAdapter=NewsAdapter(applicationContext, response.body()!!.articles)
                    val newsRecyclerView=findViewById<RecyclerView>(R.id.newsRecyclerView)
                    newsRecyclerView.layoutManager= LinearLayoutManager(applicationContext)
                    newsRecyclerView.adapter = newsAdapter
                }

                override fun onFailure(call: Call<News?>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message,Toast.LENGTH_LONG).show()
                }
            })
    }
}