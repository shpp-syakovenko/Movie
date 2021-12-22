package com.serglife.movie.domain.usecase

import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.RepoFavorites
import kotlinx.coroutines.flow.Flow

class GetFavoritesMovieUseCase(private val repo: RepoFavorites) {
    operator fun invoke(): Flow<List<Movie>> {
        return repo.getFavoritesMovies()
    }
}