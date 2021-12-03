package com.serglife.movie.data.network.api


import com.serglife.movie.data.common.ConstantNetwork
import com.serglife.movie.data.network.response.MoviesPopular
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query(QUERY_API_KEY) api_key: String = ConstantNetwork.API_KEY,
        @Query(QUERY_PAGE) page: Int = 1,
        @Query(QUERY_SORT) sort_by: String = "popularity.desc"
    ): Response<MoviesPopular>

    companion object{
        private const val QUERY_API_KEY = "api_key"
        private const val QUERY_PAGE = "page"
        private const val QUERY_SORT = "sort_by"
    }

}