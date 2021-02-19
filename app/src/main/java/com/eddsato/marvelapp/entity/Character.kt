package com.eddsato.marvelapp.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("thumbnail")
    val thumbnail: Image,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("comics")
    val comics: ComicList,
    @SerializedName("series")
    val series: SeriesList,
    @SerializedName("stories")
    val stories: StoryList,
    @SerializedName("events")
    val events: EventList,
    @SerializedName("urls")
    val urls: List<Url>
) : Parcelable