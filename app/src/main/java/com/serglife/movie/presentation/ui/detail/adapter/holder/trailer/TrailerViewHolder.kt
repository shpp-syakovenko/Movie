package com.serglife.movie.presentation.ui.detail.adapter.holder.trailer

import android.view.View
import com.serglife.movie.core.adapter.TypeViewHolder
import com.serglife.movie.databinding.ItemTrailerDetailMovieBinding

class TrailerViewHolder(itemView: View): TypeViewHolder(itemView) {
    private val binding = ItemTrailerDetailMovieBinding.bind(itemView)

    fun bind(dataHolder: TrailerDataHolder, eventHolder: TrailerEventsHolder?){
        binding.trailer = dataHolder.trailer

        binding.tvDetailTrailer.setOnClickListener {
            eventHolder?.trailerClickListener?.clickTrailer(dataHolder.trailer)
        }
        binding.executePendingBindings()
    }
}