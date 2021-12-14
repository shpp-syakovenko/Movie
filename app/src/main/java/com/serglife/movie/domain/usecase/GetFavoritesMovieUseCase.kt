package com.serglife.movie.domain.usecase

import com.serglife.movie.data.common.Either
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.RepoFavorites

class GetFavoritesMovieUseCase(private val repo: RepoFavorites) {
    suspend operator fun invoke(): Either<List<Movie>>{
        return repo.getFavoritesMovies()
    }
}