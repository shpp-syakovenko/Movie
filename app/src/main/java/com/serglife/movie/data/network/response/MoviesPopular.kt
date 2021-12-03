package com.serglife.movie.data.network.response

import com.serglife.movie.data.entity.dto.MovieDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MoviesPopular(
    @SerialName("results")
    val data: List<MovieDto>? = null
)