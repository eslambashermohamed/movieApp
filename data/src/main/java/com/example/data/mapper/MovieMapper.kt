package com.example.data.mapper

import com.example.data.dto.MovieDto
import com.example.data.dto.MovieItemDto
import com.example.domain.dto.MovieItemModel
import com.example.domain.dto.MovieModel

fun MovieDto.toMovieModel(): MovieModel {
    return MovieModel(
        page = page,
        results = results.map { it.toMovieItemModel() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

fun MovieItemDto.toMovieItemModel(): MovieItemModel {
    return MovieItemModel(
        posterPath = posterPath,
        id = id,
        title = title
    )

}