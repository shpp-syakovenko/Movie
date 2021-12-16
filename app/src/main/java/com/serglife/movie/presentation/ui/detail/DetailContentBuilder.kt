package com.serglife.movie.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import com.serglife.movie.core.adapter.TypeDataHolder
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.presentation.ui.detail.adapter.holder.movie.MovieDataHolder
import com.serglife.movie.presentation.ui.detail.adapter.holder.trailer.TrailerDataHolder
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DetailContentBuilder {

    val contentItems = MutableLiveData<MutableList<TypeDataHolder>>()

    private val movies = mutableListOf<Movie>()
    private val trailers = mutableListOf<Trailer>()

    private val mutex = Mutex()

    suspend fun addMovies(movies: List<Movie>){
        mutex.withLock {
            this.movies.apply {
                clear()
                addAll(movies)
            }
        }
    }

    suspend fun addTrailers(trailers: List<Trailer>){
        mutex.withLock {
            this.trailers.apply {
                clear()
                addAll(trailers)
            }
        }
    }

    suspend fun rebuild(){
        mutex.withLock {
            val items = mutableListOf<TypeDataHolder>()
            items.addAll(movies.map { MovieDataHolder(it) })
            items.addAll(trailers.map{ TrailerDataHolder(it) })
            contentItems.postValue(items)
        }
    }
}