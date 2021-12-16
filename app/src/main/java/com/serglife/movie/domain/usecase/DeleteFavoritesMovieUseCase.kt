package com.serglife.movie.domain.usecase

import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.DeleteFavorites

class DeleteFavoritesMovieUseCase(private val repo: DeleteFavorites) {
    suspend operator fun invoke(movie: Movie){
        repo.deleteFavoritesMovie(movie)
    }
}