package com.serglife.movie.presentation.ui.favorites.adapter

import com.serglife.movie.domain.entity.Movie

interface OnClickFavoritesListener {
    fun onClick(movie: Movie)
}