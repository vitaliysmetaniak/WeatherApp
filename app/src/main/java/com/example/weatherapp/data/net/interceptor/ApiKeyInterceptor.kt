package com.example.weatherapp.data.net.interceptor

import com.example.weatherapp.data.net.NetworkConstants
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiKeyInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url
            .newBuilder()
            .addQueryParameter("key", NetworkConstants.PRIVATE_KEY)
            .build()
        val newRequestWithApiKey = originalRequest
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(newRequestWithApiKey)
    }

}