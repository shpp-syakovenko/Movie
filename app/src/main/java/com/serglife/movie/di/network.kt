package com.serglife.movie.di

import com.serglife.movie.data.common.Mapper
import com.serglife.movie.data.database.DataBaseMovie
import com.serglife.movie.data.network.api.ApiFactory
import com.serglife.movie.data.network.api.ApiService
import org.koin.dsl.module

val network = module {
    single { ApiFactory.createApiService() }
    single { DataBaseMovie() }
    factory { Mapper() }

}