package com.eddsato.marvelapp.presentation.characterslist.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eddsato.marvelapp.databinding.FragmentFavoriteCharactersListBinding

class FavoriteCharactersListFragment : Fragment() {

    private var _binding: FragmentFavoriteCharactersListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteCharactersListBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        fun getInstance(): Fragment {
            val favoriteCharactersListFragment = FavoriteCharactersListFragment()

            return favoriteCharactersListFragment
        }
    }
}