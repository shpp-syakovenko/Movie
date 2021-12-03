package com.serglife.movie.presentation.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.serglife.movie.R
import com.serglife.movie.domain.entity.Movie

class MoviesAdapter : ListAdapter<Movie, MovieViewHolder>(MovieItemsDiffCallBack()) {

    var onClickMovieListener: OnClickMovieListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_poster_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position), onClickMovieListener)
    }
}