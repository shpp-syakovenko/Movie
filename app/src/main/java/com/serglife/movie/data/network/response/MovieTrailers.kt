package com.serglife.movie.data.network.response

import com.serglife.movie.data.entity.dto.TrailerDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieTrailers {
    @SerialName("results")
    val data: List<TrailerDto>? = null
}