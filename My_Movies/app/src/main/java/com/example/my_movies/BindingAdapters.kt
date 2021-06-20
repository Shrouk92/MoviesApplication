package com.example.my_movies

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.my_movies.adapters.RecyclerViewAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("recycler:adapter")
    fun recyclerviewadapter(recycleview :RecyclerView,adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>)
    {
        recycleview.adapter=adapter
    }
}