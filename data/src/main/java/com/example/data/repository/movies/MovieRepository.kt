package com.example.data.repository.movies

import com.example.domain.dto.MovieModel

interface MovieRepository {
    suspend fun getMovies(language: String, withGenres: String, page: Int): MovieModel
}