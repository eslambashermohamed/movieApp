package com.example.domain.dto

data class GenreModel(
    var genres: List<GenreItemModel> = arrayListOf()
)

data class GenreItemModel(
   var id: Int? = null,
   var name: String? = null
)