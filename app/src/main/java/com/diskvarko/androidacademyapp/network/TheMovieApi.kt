package com.diskvarko.androidacademyapp.network

import retrofit2.http.GET

interface TheMovieApi {
    @GET ("configuration?api_key=$API_KEY")
    suspend fun getConfiguration(): Configuration

    @GET ("movie/popular?api_key=$API_KEY")
    suspend fun getMovie(): Movie

    @GET ("movie/{movie_id}?api_key=$API_KEY&language=$LANGUAGE")
    suspend fun getDetails():Details

    @GET("person/$API_KEY?api_key=$API_KEY&language=$LANGUAGE")

    @GET("search/movie?api_key=$API_KEY&language=$LANGUAGE&page=1&include_adult=false")

}