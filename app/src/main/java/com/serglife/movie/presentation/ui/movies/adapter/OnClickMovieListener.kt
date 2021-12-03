package com.serglife.movie.presentation.ui.movies.adapter

import com.serglife.movie.domain.entity.Movie

interface OnClickMovieListener {
    fun onClick(movie: Movie)
}