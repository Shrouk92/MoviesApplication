package com.example.my_movies.repository

import android.net.Credentials
import com.example.my_movies.models.PopularMovies
import com.example.my_movies.request.ApiClient
import kotlinx.coroutines.Deferred

object Repository {

    private var endPoint: String = ""

    fun init(data: String)  {
        endPoint = data
    }

    fun GetPopularMoviesResponse():Deferred<PopularMovies>
    {
        return ApiClient.Get_APiService().
        Get_Popular_Movies(endPoint,com.example.my_movies.utils.Credentials().Api_Key)
    }


}