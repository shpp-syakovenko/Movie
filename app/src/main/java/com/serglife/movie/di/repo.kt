package com.serglife.movie.di

import com.serglife.movie.data.repositoryImpl.*
import org.koin.dsl.module

val repo = module {
    single { RepoMoviesImpl(get(), get()) }
    single { RepoTrailersImpl(get(), get()) }
    single { RepoFavoritesImpl(get()) }
    single { DeleteFavoritesImpl(get()) }
    single { AddFavoritesImpl(get()) }
    single { UpdateFavoritesImpl(get())}
}