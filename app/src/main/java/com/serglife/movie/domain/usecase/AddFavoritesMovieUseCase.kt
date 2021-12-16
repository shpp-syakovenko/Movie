package com.serglife.movie.domain.usecase

import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.AddFavorites

class AddFavoritesMovieUseCase(private val repo: AddFavorites) {
    suspend operator fun invoke(movie: Movie){
        repo.addFavoritesMovie(movie)
    }
}