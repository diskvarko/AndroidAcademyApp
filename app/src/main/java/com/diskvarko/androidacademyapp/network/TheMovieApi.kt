package com.diskvarko.androidacademyapp.network

import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieApi {
    @GET("configuration")
    suspend fun getConfiguration(): Configuration

    @GET("movie/now_playing?page=1")
    suspend fun getMovies(): Movies

    @GET("genre/movie/list")
    suspend fun getGenres(): Genres

    @GET("movie/{id}/credits")
    suspend fun getCredits(@Path("id") movieId: Long): Credits

    @GET("movie/{movieID}")
    suspend fun getDetails(@Path("movieID") movieId: Long): MovieDetails
}