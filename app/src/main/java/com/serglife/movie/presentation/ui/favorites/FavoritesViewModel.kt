package com.serglife.movie.presentation.ui.favorites

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.movie.data.common.onFailure
import com.serglife.movie.data.common.onSuccess
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.usecase.GetFavoritesMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(private val getFavorites: GetFavoritesMovieUseCase) : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    init {
        load()
    }

    private fun load() {

        viewModelScope.launch(Dispatchers.IO) {
            getFavorites()
                .onSuccess { listMovies ->
                    _movies.postValue(listMovies)
                }
                .onFailure {
                    Log.e("ERROR", it.message.toString())
                }
        }
    }

}