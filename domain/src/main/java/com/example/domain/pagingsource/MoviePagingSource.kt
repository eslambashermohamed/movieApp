package com.example.domain.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.dto.MovieItemModel
import com.example.domain.repository.MovieRepository

class MoviePagingSource(
    val language: String,
    val cateId: String,
    val movieRepository: MovieRepository
) :
    PagingSource<Int, MovieItemModel>() {
    override fun getRefreshKey(state: PagingState<Int, MovieItemModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItemModel> {
        return try {
            var page = params.key ?: 1
            val response = movieRepository.getMovies(language, cateId, page)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}