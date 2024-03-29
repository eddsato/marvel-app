package com.eddsato.marvelapp.infrastructure.network

import com.eddsato.marvelapp.entity.CharacterDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query


interface MarvelAPI {

    @GET("/v1/public/characters")
    suspend fun getCharacterList(
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): CharacterDataWrapper
}
