package com.serglife.movie.data.repositoryImpl

import com.serglife.movie.data.database.DataBaseMovie
import com.serglife.movie.domain.repository.UpdateFavorites

class UpdateFavoritesImpl(private val dataBaseMovie: DataBaseMovie): UpdateFavorites {
    override fun updateFavorites() {
        dataBaseMovie.listenMovies()
    }
}