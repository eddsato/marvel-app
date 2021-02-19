package com.eddsato.marvelapp.presentation.characterslist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.eddsato.marvelapp.entity.Character
import com.eddsato.marvelapp.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharactersListViewModel(private val repository: CharacterRepository) : ViewModel() {

    fun getCharactersList(): Flow<PagingData<Character>> =
        repository.getCharactersListStream().cachedIn(viewModelScope)
}