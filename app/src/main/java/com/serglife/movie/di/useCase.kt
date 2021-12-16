package com.serglife.movie.di

import com.serglife.movie.data.repositoryImpl.*
import com.serglife.movie.domain.usecase.*
import org.koin.dsl.module

val useCase = module {
    single { GetMoviesByPageUseCase(get<RepoMoviesImpl>()) }
    single { GetTrailersByIdUseCase(get<RepoTrailersImpl>())}
    single { GetFavoritesMovieUseCase(get<RepoFavoritesImpl>())}
    single { DeleteFavoritesMovieUseCase(get<DeleteFavoritesImpl>()) }
    single { AddFavoritesMovieUseCase(get<AddFavoritesImpl>()) }
}