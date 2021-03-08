package com.eddsato.marvelapp.presentation.characterslist.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.eddsato.marvelapp.presentation.characterslist.fragment.CharactersListFragment

class PagerAdapter(
    activity: AppCompatActivity,
    private val itemCount: Int
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = itemCount

    override fun createFragment(position: Int): Fragment =
        CharactersListFragment.getInstance()
}