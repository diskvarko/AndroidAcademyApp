package com.diskvarko.androidacademyapp.network

import com.diskvarko.androidacademyapp.data.Genre
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieApi {
    @GET("configuration")
    suspend fun getConfiguration(): Configuration

    @GET("movie/now_playing?page=1")
    suspend fun getMovies(): Movie

    @GET("genre/movie/list")
    suspend fun getGenres(): Genre

    @GET("movie/{id}/credits")
    suspend fun getCredits(@Path("id") movieId: Int): Credits

    @GET("movie/{movieID}")
    suspend fun getDetails(@Path("movieID") movieId: Int): MovieDetails
}