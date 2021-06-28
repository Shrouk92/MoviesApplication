package com.example.my_movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.my_movies.R
import com.example.my_movies.databinding.MoviesItemBinding
import com.example.my_movies.models.MovieModel
import com.bumptech.glide.Glide

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
                if(this.posterPath!=null) {

                    Glide.with(itemView)
                        .load(this.posterPath)
                        .centerCrop()
                        .error(R.drawable.ic_launcher_foreground)
                        .into(binding.imageView)
                }
            }
        }

    }

    inner class MyViewHolder(val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }





}