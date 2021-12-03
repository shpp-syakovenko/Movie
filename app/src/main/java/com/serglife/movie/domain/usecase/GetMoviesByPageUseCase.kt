package com.serglife.movie.domain.usecase

import com.serglife.movie.data.common.Either
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.RepoMovies

class GetMoviesByPageUseCase(private val repo: RepoMovies) {
    suspend operator fun invoke(page: Int): Either<List<Movie>>{
        return repo.getMoviesByPage(page)
    }
}