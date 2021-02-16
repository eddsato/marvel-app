package com.eddsato.marvelapp.di

import com.eddsato.marvelapp.infrastructure.network.RetrofitService
import org.koin.dsl.module

val marvelModule = module {
    single { RetrofitService.getInstance() }
    single { RetrofitService.provideAPIService(get()) }
}