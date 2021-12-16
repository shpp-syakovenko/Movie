package com.serglife.movie.data.repositoryImpl

import com.serglife.movie.data.database.DataBaseMovie
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.AddFavorites
import com.serglife.movie.domain.repository.DeleteFavorites

class AddFavoritesImpl(private val dataBaseMovie: DataBaseMovie): AddFavorites {
    override suspend fun addFavoritesMovie(movie: Movie) {
        dataBaseMovie.addFavorites(movie)
    }
}