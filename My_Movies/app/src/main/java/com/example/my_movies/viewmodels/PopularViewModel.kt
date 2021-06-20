package com.example.my_movies.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_movies.adapters.RecyclerViewAdapter
import com.example.my_movies.models.MovieModel
import com.example.my_movies.models.PopularMovies
import com.example.my_movies.repository.Repository
import kotlinx.coroutines.*
import kotlin.math.log

class PopularViewModel : ViewModel() {

    private val items = ArrayList<MovieModel>()
    val MoviesRecyclerViewAdapter=RecyclerViewAdapter(items)


    init {
        items.addAll(PopularMoviesResponse())
        MoviesRecyclerViewAdapter.notifyDataSetChanged()
    }

    // Coroutine .. Get Defferd data

    fun PopularMoviesResponse(): ArrayList<MovieModel> {
        var Deffered_response = Repository.GetPopularMoviesResponse()

        try {
            runBlocking {

                var list = Deffered_response.await()
                for (item in list.results) {
                    var Img_URL = "https://image.tmdb.org/t/p/w500" + item.posterPath
                    item.posterPath = Img_URL

                }
                items.addAll(list.results)
            }

        } catch (e: Throwable) {
            Log.d("Faild", "Faild sresponse")

        }
        return items

    }


}