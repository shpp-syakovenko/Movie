package com.serglife.movie.data.network.api


import com.serglife.movie.data.network.response.MovieTrailers
import com.serglife.movie.data.network.response.MoviesPopular
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(
        @QueryMap options:Map<String, String>
    ): Response<MoviesPopular>

    @GET("movie/{id}/videos")
    suspend fun getTrailers(
        @Path("id") id: Int,
        @QueryMap options:Map<String, String>
    ): Response<MovieTrailers>
}