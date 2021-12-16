package com.serglife.movie.presentation.ui.detail.adapter.listener

import com.serglife.movie.domain.entity.Movie

interface ClickMovieListener {
    fun clickAddOrDeleteMovieFromFavorites(movie: Movie)
}