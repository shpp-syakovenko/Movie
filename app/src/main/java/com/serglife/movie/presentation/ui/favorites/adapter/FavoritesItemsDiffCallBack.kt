package com.serglife.movie.presentation.ui.favorites.adapter

import androidx.recyclerview.widget.DiffUtil
import com.serglife.movie.domain.entity.Movie

class FavoritesItemsDiffCallBack : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == oldItem
    }
}