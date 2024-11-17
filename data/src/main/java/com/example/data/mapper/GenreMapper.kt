package com.example.data.mapper

import com.example.data.dto.GenreDto
import com.example.data.dto.GenreItemDto
import com.example.domain.dto.GenreItemModel
import com.example.domain.dto.GenreModel


fun GenreDto.toGenreModel(): GenreModel {

    return GenreModel(
        genres = genres.map { it.toGenreItemModel() } )

}
fun GenreItemDto.toGenreItemModel(): GenreItemModel {
    return GenreItemModel(
        id = id,
        name = name
    )
}
