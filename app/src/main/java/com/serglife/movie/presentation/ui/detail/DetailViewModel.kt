package com.serglife.movie.presentation.ui.detail


import androidx.lifecycle.*
import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.data.common.onFailure
import com.serglife.movie.data.common.onSuccess
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.domain.usecase.*
import kotlinx.coroutines.launch

class DetailViewModel(
    getFavorites: GetFavoritesMovieUseCase,
    private val getTrailersByIdUseCase: GetTrailersByIdUseCase,
    private val deleteFavoritesMovieUseCase: DeleteFavoritesMovieUseCase,
    private val addFavoritesMovieUseCase: AddFavoritesMovieUseCase,
    private val updateFavoritesUseCase: UpdateFavoritesUseCase

    ): ViewModel() {
    val moviesFavorites: LiveData<List<Movie>> = getFavorites().asLiveData()

    private val contentBuilder = DetailContentBuilder()
    val detailItems:LiveData<MutableList<TypeDataHolder>> = contentBuilder.contentItems

    fun deleteFavorites(movie: Movie){
        viewModelScope.launch {
            deleteFavoritesMovieUseCase(movie)
        }
    }

    fun addFavorites(movie:Movie){
        viewModelScope.launch {
            addFavoritesMovieUseCase(movie)
        }
    }

    fun updateFavorites(){
        updateFavoritesUseCase()
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