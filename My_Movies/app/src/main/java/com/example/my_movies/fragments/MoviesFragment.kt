package com.example.my_movies.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_movies.R
import androidx.recyclerview.widget.RecyclerView
import com.example.my_movies.adapters.RecyclerViewAdapter
import com.example.my_movies.databinding.FragmentMoviesBinding
import com.example.my_movies.models.MovieModel
import com.example.my_movies.viewmodels.PopularViewModel

class MoviesFragment : Fragment() {
    private lateinit var RecyclerBinding:FragmentMoviesBinding
    private lateinit var MovieViewModel:PopularViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MovieViewModel=ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
            .create(PopularViewModel::class.java)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        RecyclerBinding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_movies,container,false)
        RecyclerBinding.rvb=MovieViewModel
        RecyclerBinding.lifecycleOwner=this
        return RecyclerBinding.root
    }






}