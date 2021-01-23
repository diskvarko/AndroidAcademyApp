package com.diskvarko.androidacademyapp.network

import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieApi {
    @GET("configuration?api_key=$API_KEY")
    suspend fun getConfiguration(): Configuration

    @GET("movie/now_playing?api_key=$API_KEY&language=$LANGUAGE&page=1")
    suspend fun getMovies(): Movies

    @GET("genre/movie/list?api_key=$API_KEY&language=$LANGUAGE")
    suspend fun getGenres(): Genres

    @GET("movie/{id}/credits?api_key=$API_KEY&language=$LANGUAGE")
    suspend fun getCredits(@Path("id") movieId: Long): Credits

    @GET("movie/{id}?api_key=$API_KEY&language=$LANGUAGE")
    suspend fun getDetails(@Path("id") movieId: Long): MovieDetails
}