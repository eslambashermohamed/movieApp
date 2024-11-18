package com.example.domain.usecases

import com.example.domain.dto.GenreModel
import com.example.domain.repository.CategoriesRepo
import com.example.domain.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(val categoriesRepo: CategoriesRepo) {
    operator fun invoke(language: String): Flow<Resources<GenreModel>> = flow {
        try {
            emit(Resources.Loading())
            val response = categoriesRepo.getCategories(language)
            emit(Resources.Success(response))
        } catch (e: Exception) {
            emit(Resources.Error(null, e.message.toString()))
        }
    }
}