package com.serglife.movie.domain.repository

import com.serglife.movie.domain.entity.Movie

interface DeleteFavorites {
    suspend fun deleteFavoritesMovie(movie: Movie)
}