package com.example.data.repository.categories

import com.example.domain.dto.GenreModel

interface CategoriesRepo {
    suspend fun getCategories(language:String): GenreModel
}