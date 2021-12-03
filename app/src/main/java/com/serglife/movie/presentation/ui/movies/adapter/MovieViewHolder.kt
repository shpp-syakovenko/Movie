package com.serglife.movie.presentation.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.serglife.movie.databinding.ItemPosterMovieBinding
import com.serglife.movie.domain.entity.Movie

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemPosterMovieBinding.bind(itemView)

    fun bind(movie: Movie, onClickMovieListener: OnClickMovieListener?){
        binding.movie = movie
        binding.root.setOnClickListener {
            onClickMovieListener?.onClick(movie)
        }
    }
}