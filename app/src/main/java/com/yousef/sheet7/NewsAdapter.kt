package com.yousef.sheet7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yousef.sheet7.model.Article

class NewsAdapter(private val context: Context, var articles: List<Article>) : RecyclerView.Adapter<NewsAdapter.NewsHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val article= articles[position]
        holder.title.text=article.title
        Picasso.with(context).load(article.urlToImage).error(R.color.teal_700).into(holder.photo)
    }

    override fun getItemCount(): Int {
        return articles.size
    }


    class NewsHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val photo = itemView.findViewById<ImageView>(R.id.photo)!!
        val title = itemView.findViewById<TextView>(R.id.title)!!
    }
}