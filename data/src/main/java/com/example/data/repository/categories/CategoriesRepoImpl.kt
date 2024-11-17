package com.example.data.repository.categories

import com.example.data.mapper.toGenreModel
import com.example.data.remote.ApiMovieService
import com.example.domain.dto.GenreModel
import javax.inject.Inject

class CategoriesRepoImpl @Inject constructor(private val apiMovieService: ApiMovieService) :CategoriesRepo {
    override suspend fun getCategories(language: String): GenreModel {
       return apiMovieService.getCategories().toGenreModel()
    }
}