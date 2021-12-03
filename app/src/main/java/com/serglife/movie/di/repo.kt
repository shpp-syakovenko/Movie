package com.serglife.movie.di

import com.serglife.movie.data.repositoryImpl.RepoMoviesImpl
import org.koin.dsl.module

val repo = module {
    single { RepoMoviesImpl(get(),get()) }
}