package com.serglife.movie.data.repositoryImpl

import com.serglife.movie.data.common.Either
import com.serglife.movie.data.common.Mapper
import com.serglife.movie.data.network.api.ApiService
import com.serglife.movie.domain.entity.Movie
import com.serglife.movie.domain.repository.RepoMovies
import java.lang.Exception

class RepoMoviesImpl(private val mapper: Mapper, private val api: ApiService): RepoMovies {
    override suspend fun getMoviesByPage(page: Int): Either<List<Movie>> {

        val response = api.getMovies(page = page)
        val listMovies = response.body()?.data

        return if(!response.isSuccessful || listMovies == null){
            Either.failure(Exception("Fail response!!!"))
        }else{
            Either.success(mapper.listMovieDtoToListMovie(listMovies))
        }
    }
}