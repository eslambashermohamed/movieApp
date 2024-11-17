package com.example.data.repository.movies

import com.example.data.mapper.toMovieModel
import com.example.data.remote.ApiMovieService
import com.example.domain.dto.MovieModel
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiMovieService: ApiMovieService
) : MovieRepository {
    override suspend fun getMovies(
        language: String, withGenres: String, page: Int
    ): MovieModel {
        return apiMovieService.getMovies(language, withGenres, page).toMovieModel()
    }
}