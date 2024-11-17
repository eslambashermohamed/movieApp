package com.example.movieapp

import com.example.data.remote.ApiMovieService
import com.example.data.repository.categories.CategoriesRepo
import com.example.data.repository.categories.CategoriesRepoImpl
import com.example.data.repository.movies.MovieRepository
import com.example.data.repository.movies.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getApiServiece(retrofit: Retrofit): ApiMovieService =
        retrofit.create(ApiMovieService::class.java)

    @Provides
    @Singleton
    fun getMovieRepository(apiMovieService: ApiMovieService): MovieRepository =
        MovieRepositoryImpl(apiMovieService)
   @Provides
   @Singleton
   fun getCategoriesRepository(apiMovieService: ApiMovieService): CategoriesRepo =
       CategoriesRepoImpl(apiMovieService)

}