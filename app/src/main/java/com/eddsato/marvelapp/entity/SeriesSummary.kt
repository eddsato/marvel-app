package com.eddsato.marvelapp.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SeriesSummary (
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("name")
    val name: String
) : Parcelable