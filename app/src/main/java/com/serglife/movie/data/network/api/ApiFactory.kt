package com.serglife.movie.data.network.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.serglife.movie.data.common.ConstantNetwork
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object ApiFactory {
    fun createApiService():ApiService{
        val contentType = MediaType.get("application/json")
        val json = Json{ ignoreUnknownKeys = true; encodeDefaults = true }

        return Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(ConstantNetwork.BASE_URL_API)
            .build()
            .create(ApiService::class.java)
    }
}