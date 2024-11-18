package com.example.domain.repository

import com.example.domain.dto.MovieModel

interface MovieRepository {
    suspend fun getMovies(language: String, withGenres: String, page: Int): MovieModel
}