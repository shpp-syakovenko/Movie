package com.serglife.movie.data.entity.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieDto(
    @SerialName("id")
    val id: Int,

    @SerialName("poster_path")
    val poster_path: String?,

    @SerialName("title")
    val title: String,

    @SerialName("overview")
    val overview: String,

    @SerialName("vote_average")
    val vote_average: Double,

    @SerialName("release_date")
    val release_date: String
)