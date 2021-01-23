package com.diskvarko.androidacademyapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object Retrofit {

    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(ApiKeyInterceptor())
        .build()

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(contentType))
        .client(okHttpClient)
        .build()

    val movieApi: TheMovieApi = retrofitBuilder.create(TheMovieApi::class.java)


}