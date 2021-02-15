package com.eddsato.marvelapp.network

import com.eddsato.marvelapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    fun getInstance(): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideAPIService(retrofit: Retrofit): MarvelAPI =
        retrofit.create(MarvelAPI::class.java)
}