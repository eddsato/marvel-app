package com.eddsato.marvelapp.presentation.characterslist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eddsato.marvelapp.R
import com.eddsato.marvelapp.databinding.ActivityCharactersListBinding
import com.eddsato.marvelapp.presentation.characterslist.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class CharactersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharactersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupPagerAdapter()
    }

    private fun setupPagerAdapter() {
        val pageNamesArray = resources.getStringArray(R.array.characters_page_names)
        val pagerAdapter = PagerAdapter(this, pageNamesArray.size)

        binding.charactersViewPager.adapter = pagerAdapter

        TabLayoutMediator(
            binding.charactersTabLayout,
            binding.charactersViewPager
        ) { tab, position ->
            tab.text = pageNamesArray[position]
        }.attach()
    }
}