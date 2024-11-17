package com.example.domain.dto

data class MovieModel(

    var page: Int? = null,
    var results: List<MovieItemModel> = emptyList(),
    var totalPages: Int? = null,
    var totalResults: Int? = null

)


data class MovieItemModel(

    var posterPath: String? = null,
    var id: Int? = null,
    var originalTitle: String? = null,
    var title: String? = null,


    )