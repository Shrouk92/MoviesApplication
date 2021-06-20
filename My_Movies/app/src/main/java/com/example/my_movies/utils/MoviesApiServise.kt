package com.example.my_movies.utils

import com.example.my_movies.models.PopularMovies
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiServise {

    @GET("movie/popular")
    fun Get_Popular_Movies(
        @Query("api_key") APi_key:String,
    ): Deferred<PopularMovies>
}