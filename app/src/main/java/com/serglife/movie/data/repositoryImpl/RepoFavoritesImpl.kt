package com.serglife.movie.data.repositoryImpl


import com.serglife.movie.data.database.DataBaseMovie
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.RepoFavorites
import kotlinx.coroutines.flow.Flow

class RepoFavoritesImpl(private val dataBaseMovie: DataBaseMovie) : RepoFavorites {

    override fun getFavoritesMovies(): Flow<List<Movie>> {
        return dataBaseMovie.movies
    }
}