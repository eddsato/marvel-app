package com.eddsato.marvelapp.di

import com.eddsato.marvelapp.infrastructure.network.RetrofitService
import com.eddsato.marvelapp.presentation.characterslist.viewmodel.CharactersListViewModel
import com.eddsato.marvelapp.repository.CharacterRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val marvelModule = module {
    single { RetrofitService.getInstance() }
    single { RetrofitService.provideAPIService(get()) }
    single { CharacterRepository(get()) }

    viewModel { CharactersListViewModel(get()) }
}