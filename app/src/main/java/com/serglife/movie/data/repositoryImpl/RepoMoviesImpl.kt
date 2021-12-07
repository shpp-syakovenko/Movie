package com.serglife.movie.data.repositoryImpl

import com.serglife.movie.data.common.ConstantNetwork
import com.serglife.movie.data.common.Either
import com.serglife.movie.data.common.Mapper
import com.serglife.movie.data.network.api.ApiService
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.RepoMovies
import java.lang.Exception

class RepoMoviesImpl(private val mapper: Mapper, private val api: ApiService): RepoMovies {
    override suspend fun getMoviesByPage(page: Int): Either<List<Movie>> {

        val options = getOptionsMoviePopular(page = page)
        val response = api.getMovies(options = options)
        val listMovies = response.body()?.data

        return if(!response.isSuccessful || listMovies == null){
            Either.failure(Exception("Fail response!!!"))
        }else{
            Either.success(mapper.listMovieDtoToListMovie(listMovies))
        }
    }

    private fun getOptionsMoviePopular(page: Int): Map<String, String> {
        val options = mutableMapOf<String, String>()
        options[QUERY_API_KEY] = ConstantNetwork.API_KEY
        options[QUERY_PAGE] = page.toString()
        options[QUERY_SORT_KEY] = QUERY_SORT_VALUE
        return options
    }

    companion object{
        private const val QUERY_API_KEY = "api_key"
        private const val QUERY_PAGE = "page"
        private const val QUERY_SORT_KEY = "sort_by"

        private const val QUERY_SORT_VALUE = "popularity.desc"
    }
}
