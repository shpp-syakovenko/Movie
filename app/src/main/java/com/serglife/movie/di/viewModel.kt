package com.serglife.movie.di

import com.serglife.movie.presentation.ui.detail.DetailViewModel
import com.serglife.movie.presentation.ui.movies.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}