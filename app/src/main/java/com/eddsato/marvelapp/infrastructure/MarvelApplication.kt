package com.eddsato.marvelapp.infrastructure

import android.app.Application
import com.eddsato.marvelapp.di.marvelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MarvelApplication)
            modules(marvelModule)
        }
    }
}