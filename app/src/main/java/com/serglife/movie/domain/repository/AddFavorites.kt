package com.serglife.movie.domain.repository

import com.serglife.movie.domain.entity.Movie

interface AddFavorites {
    suspend fun addFavoritesMovie(movie: Movie)
}