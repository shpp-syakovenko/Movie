package com.serglife.movie.domain.repository

import com.serglife.movie.data.common.Either
import com.serglife.movie.domain.entity.Movie

interface RepoMovies {
    suspend fun getMoviesByPage(page:Int): Either<List<Movie>>
}