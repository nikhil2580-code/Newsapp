package com.nikhilkhairnar.thenewsapp.repository

import com.nikhilkhairnar.thenewsapp.api.RetrofitInstance
import com.nikhilkhairnar.thenewsapp.db.ArticleDatabase
import com.nikhilkhairnar.thenewsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)



}