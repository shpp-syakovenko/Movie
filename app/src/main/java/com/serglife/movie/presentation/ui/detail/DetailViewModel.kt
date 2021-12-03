package com.serglife.movie.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.domain.entity.Movie
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val contentBuilder = DetailContentBuilder()
    val detailItems:LiveData<MutableList<TypeDataHolder>> = contentBuilder.contentItems

    fun loadDetailMovie(movie: Movie){
        viewModelScope.launch {

            contentBuilder.apply {
                addMovies(listOf(movie))
                rebuild()
            }
        }
    }
}