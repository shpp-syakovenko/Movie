package com.serglife.movie.data.repositoryImpl

import com.serglife.movie.data.common.Either
import com.serglife.movie.data.database.DataBaseMovie
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.RepoFavorites

class RepoFavoritesImpl(private val dataBaseMovie: DataBaseMovie) : RepoFavorites {

    override suspend fun getFavoritesMovies(): Either<List<Movie>> {

        val list = dataBaseMovie.getFavorites()

        return if(list.isNotEmpty()){
            Either.success(list)
        }else{
            Either.failure(Exception("Not favorites movie"))
        }
    }
}