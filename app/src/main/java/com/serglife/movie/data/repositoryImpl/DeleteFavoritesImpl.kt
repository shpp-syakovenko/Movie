package com.serglife.movie.data.repositoryImpl

import com.serglife.movie.data.database.DataBaseMovie
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.DeleteFavorites

class DeleteFavoritesImpl(private val dataBaseMovie: DataBaseMovie): DeleteFavorites {
    override suspend fun deleteFavoritesMovie(movie: Movie) {
        dataBaseMovie.deleteFavorites(movie)
    }
}