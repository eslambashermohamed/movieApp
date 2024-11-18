package com.example.domain.repository

import com.example.domain.dto.GenreModel

interface CategoriesRepo {
    suspend fun getCategories(language:String): GenreModel
}