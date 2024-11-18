package com.example.domain.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.domain.dto.MovieItemModel
import com.example.domain.dto.MovieModel
import com.example.domain.pagingsource.MoviePagingSource
import com.example.domain.repository.MovieRepository
import com.example.domain.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesUsecases @Inject constructor(val movieRepository: MovieRepository) {
    operator fun invoke(language: String,cateId:String) : Flow<Resources<Pager<Int, MovieItemModel>>> = flow {
        try {
            emit(Resources.Loading())
            val getMovie=Pager(
                config = PagingConfig(pageSize = 20),
                pagingSourceFactory = {
                    MoviePagingSource(language,cateId,movieRepository)
                }

            )

        }catch (e:Exception){

        }

    }
}