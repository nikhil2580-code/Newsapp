package com.nikhilkhairnar.thenewsapp.api

import com.nikhilkhairnar.thenewsapp.models.NewsResponse
import com.nikhilkhairnar.thenewsapp.util.Constants.Companion.API_KEY
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        countryCode:String = "us",
        @Query("page")
        pageNumber:Int = 1,
        @Query("apiKey")
        apiKey:String = API_KEY


    ): retrofit2.Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): retrofit2.Response<NewsResponse>


}