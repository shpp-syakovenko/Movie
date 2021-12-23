package com.serglife.movie.presentation.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.usecase.GetFavoritesMovieUseCase
import com.serglife.movie.domain.usecase.UpdateFavoritesUseCase

class FavoritesViewModel(
    getFavorites: GetFavoritesMovieUseCase,
    private val updateFavoritesUseCase: UpdateFavoritesUseCase
    ) : ViewModel() {

    val movies: LiveData<List<Movie>> = getFavorites().asLiveData()

    fun updateFavorites(){
        updateFavoritesUseCase()
    }

}