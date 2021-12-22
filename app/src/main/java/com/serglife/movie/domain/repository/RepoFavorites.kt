package com.serglife.movie.domain.repository


import com.serglife.movie.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface RepoFavorites {
   fun getFavoritesMovies(): Flow<List<Movie>>
}