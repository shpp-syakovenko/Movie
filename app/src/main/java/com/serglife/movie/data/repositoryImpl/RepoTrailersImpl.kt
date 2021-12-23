package com.serglife.movie.data.repositoryImpl

import com.serglife.movie.data.common.ConstantNetwork
import com.serglife.movie.data.common.Either
import com.serglife.movie.data.common.Mapper
import com.serglife.movie.data.network.api.ApiService
import com.serglife.movie.domain.entity.Trailer
import com.serglife.movie.domain.repository.RepoTrailers
import java.lang.Exception

class RepoTrailersImpl(private val mapper: Mapper, private val api: ApiService) : RepoTrailers {
    override suspend fun getTrailersById(id: Int): Either<List<Trailer>> {
        val options = getOptionsTrailer()

        val response = api.getTrailers(id, options)
        val data = response.body()?.data

        return if (!response.isSuccessful || data == null) {
            Either.failure(Exception("Fail response!!!"))
        } else {
            Either.success(mapper.listTrailersDtoToListTrailers(data))
        }
    }

    private fun getOptionsTrailer(): Map<String, String> {
        val options = mutableMapOf<String, String>()
        options[QUERY_API_KEY] = ConstantNetwork.API_KEY
        return options

    }

    companion object {
        private const val QUERY_API_KEY = "api_key"
    }
}