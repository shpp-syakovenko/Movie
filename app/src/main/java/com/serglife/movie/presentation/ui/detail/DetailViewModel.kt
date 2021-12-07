package com.serglife.movie.presentation.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.data.common.onFailure
import com.serglife.movie.data.common.onSuccess
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.domain.usecase.GetTrailersByIdUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val getTrailersByIdUseCase: GetTrailersByIdUseCase): ViewModel() {

    private val contentBuilder = DetailContentBuilder()
    val detailItems:LiveData<MutableList<TypeDataHolder>> = contentBuilder.contentItems

    fun loadDetailMovie(movie: Movie){

        viewModelScope.launch {

            contentBuilder.apply {
                addMovies(listOf(movie))
                addTrailers(getTrailerById(movie.id))
                rebuild()
            }
        }
    }

    private suspend fun getTrailerById(id:Int): List<Trailer>{

        var list = listOf<Trailer>()
        getTrailersByIdUseCase(id)
            .onSuccess { list = it  }
            .onFailure {  }
        return list
    }
}