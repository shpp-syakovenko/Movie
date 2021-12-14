package com.serglife.movie.presentation.ui.favorites.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.serglife.movie.databinding.ItemPosterMovieBinding
import com.serglife.movie.domain.entity.Movie

class FavoritesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemPosterMovieBinding.bind(itemView)

    fun bind(movie: Movie, onClickFavoritesListener: OnClickFavoritesListener?){

        binding.movie = movie
        binding.root.setOnClickListener {
            onClickFavoritesListener?.onClick(movie)
        }
    }
}