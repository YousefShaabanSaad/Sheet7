package com.yousef.sheet7.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)