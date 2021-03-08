package com.eddsato.marvelapp.presentation.characterslist.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.eddsato.marvelapp.databinding.FragmentCharactersListBinding
import com.eddsato.marvelapp.presentation.characterslist.adapter.CharactersAdapter
import com.eddsato.marvelapp.presentation.characterslist.viewmodel.CharactersListViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListFragment : Fragment() {

    private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharactersListViewModel by viewModel()
    private val adapter = CharactersAdapter()

    private var characterListJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharactersListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    companion object {
        fun getInstance(): Fragment {
            val charactersListFragment = CharactersListFragment()

            return charactersListFragment
        }
    }
}