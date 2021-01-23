package com.diskvarko.androidacademyapp.network

import com.diskvarko.androidacademyapp.BuildConfig
import com.diskvarko.androidacademyapp.R
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val url = original.url.newBuilder()
            .setQueryParameter("api_key", API_KEY)
            .setQueryParameter("language", LANGUAGE)
            .build()
        val request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}