package com.serglife.movie.domain.usecase

import com.serglife.movie.domain.repository.UpdateFavorites

class UpdateFavoritesUseCase(private val repo: UpdateFavorites) {
    operator fun invoke(){
        repo.updateFavorites()
    }
}