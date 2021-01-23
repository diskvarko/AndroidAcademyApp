package com.diskvarko.androidacademyapp.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val request = original.newBuilder()
            .header("api-key", API_KEY)
            .header("language", LANGUAGE)
            .build()
        return chain.proceed(request)
    }
}