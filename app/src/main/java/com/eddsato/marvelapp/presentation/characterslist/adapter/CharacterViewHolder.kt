package com.eddsato.marvelapp.presentation.characterslist.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.eddsato.marvelapp.R
import com.eddsato.marvelapp.entity.Character

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.character_list_name)

    private var character: Character? = null

    init {
        view.setOnClickListener {
            Toast.makeText(view.context, "Clicked", Toast.LENGTH_LONG).show()
        }
    }

    fun bind(character: Character) {
        this.character = character

        name.text = character.name
    }

    companion object {
        fun create(parent: ViewGroup): CharacterViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.character_item_list, parent, false)
            return CharacterViewHolder(view)
        }
    }
}