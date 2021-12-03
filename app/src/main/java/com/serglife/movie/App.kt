package com.serglife.movie

import android.app.Application
import com.serglife.movie.di.network
import com.serglife.movie.di.repo
import com.serglife.movie.di.useCase
import com.serglife.movie.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(network, repo, useCase, viewModel))
        }
    }
}