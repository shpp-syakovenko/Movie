package com.serglife.movie.domain.repository

import com.serglife.movie.data.common.Either
import com.serglife.movie.domain.entity.Movie

interface RepoFavorites {
   suspend fun getFavoritesMovies(): Either<List<Movie>>
}