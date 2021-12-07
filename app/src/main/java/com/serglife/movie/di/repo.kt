package com.serglife.movie.di

import com.serglife.movie.data.repositoryImpl.RepoMoviesImpl
import com.serglife.movie.data.repositoryImpl.RepoTrailersImpl
import org.koin.dsl.module

val repo = module {
    single { RepoMoviesImpl(get(), get()) }
    single { RepoTrailersImpl(get(), get()) }
}