package com.eddsato.marvelapp.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Image (
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
) : Parcelable