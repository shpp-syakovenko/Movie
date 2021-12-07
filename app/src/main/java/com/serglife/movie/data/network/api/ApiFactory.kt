package com.serglife.movie.data.network.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.serglife.movie.data.common.ConstantNetwork
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient

object ApiFactory {
    fun createApiService():ApiService{

        val interceptor = HttpLoggingInterceptor()
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val contentType = "application/json".toMediaType()
        val json = Json{ ignoreUnknownKeys = true; encodeDefaults = true }

        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(ConstantNetwork.BASE_URL_API)
            .build()
            .create(ApiService::class.java)
    }
}