package com.eddsato.marvelapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.eddsato.marvelapp.entity.Character
import com.eddsato.marvelapp.infrastructure.network.MarvelAPI
import kotlinx.coroutines.flow.Flow

class CharacterRepository(private val api: MarvelAPI) {

    fun getCharactersListStream(): Flow<PagingData<Character>> {
        return Pager(
                config = PagingConfig(pageSize = RESULT_PAGE_SIZE, enablePlaceholders = false),
                pagingSourceFactory = { CharacterPagingSource(api) }
        ).flow
    }

    companion object {
        private const val RESULT_PAGE_SIZE = 20
    }
}