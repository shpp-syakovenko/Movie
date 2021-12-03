package com.serglife.movie.presentation.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.movie.data.common.onFailure
import com.serglife.movie.data.common.onSuccess
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.usecase.GetMoviesByPageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val getMoviesByPage: GetMoviesByPageUseCase) : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private var page = 1
    private var isLoading = false

    init {
        load()
    }

    fun load() {
        if(isLoading) return
        isLoading = true

        viewModelScope.launch(Dispatchers.IO) {
            getMoviesByPage(page = page)
                .onSuccess {listMovies ->
                    updateListMovies(listMovies)
                }
                .onFailure {
                    Log.e("ERROR", it.message.toString())
                    isLoading = false
                }
        }
    }

    private fun updateListMovies(listMovies: List<Movie>) {
        val newListMovies = mutableListOf<Movie>()
        newListMovies.addAll(_movies.value ?: mutableListOf())
        newListMovies.addAll(listMovies)
        _movies.postValue(newListMovies)
        page++
        isLoading = false
    }

}