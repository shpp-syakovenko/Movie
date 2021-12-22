package com.serglife.movie.presentation.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.usecase.GetFavoritesMovieUseCase

class FavoritesViewModel(private val getFavorites: GetFavoritesMovieUseCase) : ViewModel() {

    val movies: LiveData<List<Movie>> = getFavorites().asLiveData()

}