package com.serglife.movie.di

import com.serglife.movie.data.repositoryImpl.RepoFavoritesImpl
import com.serglife.movie.data.repositoryImpl.RepoMoviesImpl
import com.serglife.movie.data.repositoryImpl.RepoTrailersImpl
import com.serglife.movie.domain.usecase.GetFavoritesMovieUseCase
import com.serglife.movie.domain.usecase.GetMoviesByPageUseCase
import com.serglife.movie.domain.usecase.GetTrailersByIdUseCase
import org.koin.dsl.module

val useCase = module {
    single { GetMoviesByPageUseCase(get<RepoMoviesImpl>()) }
    single { GetTrailersByIdUseCase(get<RepoTrailersImpl>())}
    single { GetFavoritesMovieUseCase(get<RepoFavoritesImpl>())}
}