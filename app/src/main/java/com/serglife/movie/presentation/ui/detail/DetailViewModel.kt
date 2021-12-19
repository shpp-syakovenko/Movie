package com.serglife.movie.presentation.ui.detail


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.data.common.onFailure
import com.serglife.movie.data.common.onSuccess
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.domain.usecase.AddFavoritesMovieUseCase
import com.serglife.movie.domain.usecase.DeleteFavoritesMovieUseCase
import com.serglife.movie.domain.usecase.GetFavoritesMovieUseCase
import com.serglife.movie.domain.usecase.GetTrailersByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getTrailersByIdUseCase: GetTrailersByIdUseCase,
    private val getFavorites: GetFavoritesMovieUseCase,
    private val deleteFavoritesMovieUseCase: DeleteFavoritesMovieUseCase,
    private val addFavoritesMovieUseCase: AddFavoritesMovieUseCase,

    ): ViewModel() {

    private var _moviesFavorites = MutableLiveData<List<Movie>>()
    val moviesFavorites: LiveData<List<Movie>> = _moviesFavorites

    private val contentBuilder = DetailContentBuilder()
    val detailItems:LiveData<MutableList<TypeDataHolder>> = contentBuilder.contentItems

    fun deleteFavorites(movie: Movie, function: () -> Unit){
        viewModelScope.launch {
            deleteFavoritesMovieUseCase(movie)
            function()
        }
    }

    fun addFavorites(movie:Movie, function: () -> Unit){
        viewModelScope.launch {
            addFavoritesMovieUseCase(movie)
            function()
        }
    }

     fun loadFavoritesMovie() {

        viewModelScope.launch(Dispatchers.IO) {
            getFavorites()
                .onSuccess { listMovies ->
                    _moviesFavorites.postValue(listMovies)
                }
                .onFailure {
                    _moviesFavorites.postValue(listOf())
                }
        }
    }

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