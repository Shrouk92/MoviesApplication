package com.example.my_movies.request

import com.example.my_movies.utils.Credentials
import com.example.my_movies.utils.MoviesApiServise
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun Get_APiService():MoviesApiServise
    {
        return Retrofit.Builder()
            .baseUrl(Credentials().Baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(MoviesApiServise::class.java)

    }
}