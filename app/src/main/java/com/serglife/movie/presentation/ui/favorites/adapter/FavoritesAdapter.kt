package com.serglife.movie.presentation.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.serglife.movie.R
import com.serglife.movie.domain.entity.Movie

class FavoritesAdapter : ListAdapter<Movie, FavoritesViewHolder>(FavoritesItemsDiffCallBack()) {

    var onClickFavoritesListener: OnClickFavoritesListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_poster_movie, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(getItem(position), onClickFavoritesListener)
    }
}