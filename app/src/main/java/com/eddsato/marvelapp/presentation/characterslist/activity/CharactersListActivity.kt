package com.eddsato.marvelapp.presentation.characterslist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.eddsato.marvelapp.databinding.ActivityCharactersListBinding
import com.eddsato.marvelapp.presentation.characterslist.adapter.CharactersAdapter
import com.eddsato.marvelapp.presentation.characterslist.viewmodel.CharactersListViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharactersListBinding

    private val viewModel: CharactersListViewModel by viewModel()
    private val adapter = CharactersAdapter()

    private var characterListJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAdapter()
        getCharactersList()
    }

    private fun initAdapter() {
        binding.characterListRecycle.adapter = adapter
    }

    private fun getCharactersList() {
        characterListJob?.cancel()
        characterListJob = lifecycleScope.launch {
            viewModel.getCharactersList().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}