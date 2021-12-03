package com.serglife.movie.di

import com.serglife.movie.data.repositoryImpl.RepoMoviesImpl
import com.serglife.movie.domain.usecase.GetMoviesByPageUseCase
import org.koin.dsl.module

val useCase = module {
    single { GetMoviesByPageUseCase(get<RepoMoviesImpl>()) }
}