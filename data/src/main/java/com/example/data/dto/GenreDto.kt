package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("genres") var genres: ArrayList<GenreItemDto> = arrayListOf()
)

data class GenreItemDto(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null
)