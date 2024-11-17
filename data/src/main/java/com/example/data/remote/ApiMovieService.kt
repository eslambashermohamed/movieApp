package com.example.data.remote

import com.example.data.dto.GenreDto
import com.example.data.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMovieService {
    @GET("genre/movie/list?api_key=3db2c1d15b330e8595099a2bab78dce2")
    suspend fun getCategories(@Query("language") language: String="en"): GenreDto
    
    @GET("discover/movie?api_key=3db2c1d15b330e8595099a2bab78dce2")
    suspend fun getMovies(@Query("language") language: String="en",
                          @Query("with_genres") withGenres: String,
                          @Query("page") page: Int): MovieDto
}