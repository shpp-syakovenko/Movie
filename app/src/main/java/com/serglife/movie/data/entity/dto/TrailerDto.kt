package com.serglife.movie.data.entity.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TrailerDto(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("key")
    val key: String
)