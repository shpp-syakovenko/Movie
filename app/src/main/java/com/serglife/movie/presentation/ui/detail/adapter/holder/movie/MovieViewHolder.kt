package com.serglife.movie.presentation.ui.detail.adapter.holder.movie

import android.view.View
import com.serglife.movie.core.adapter.TypeViewHolder
import com.serglife.movie.databinding.ItemHeaderDetailMovieBinding

class MovieViewHolder(itemView: View): TypeViewHolder(itemView) {
    private val binding = ItemHeaderDetailMovieBinding.bind(itemView)

    fun bind(dataHolder: MovieDataHolder){
        binding.movie = dataHolder.movie
        binding.executePendingBindings()
    }
}