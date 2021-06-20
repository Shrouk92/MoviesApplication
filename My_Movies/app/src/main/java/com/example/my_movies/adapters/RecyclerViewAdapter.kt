package com.example.my_movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.my_movies.R
import com.example.my_movies.databinding.MoviesItemBinding
import com.example.my_movies.models.MovieModel
import com.example.my_movies.viewmodels.PopularViewModel

class RecyclerViewAdapter (val list: ArrayList<MovieModel>):RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {


        val moviesItemBinding:MoviesItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.movies_item,parent,false)

        return MyViewHolder(moviesItemBinding)
    }
    override fun getItemCount(): Int=list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder)
        {
            with(list[position])
            {
                binding.movieTitle.text=this.originalTitle
                binding.ratingBar.rating=this.voteCount.toFloat()
                binding.date.text=this.releaseDate
            }
        }

    }

    inner class MyViewHolder(val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }





}