package com.star.network.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val secret: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentRequest = chain.request()

        // TODO (change what is necessary if any)
        val url = currentRequest
            .url()
            .newBuilder()
            .addQueryParameter("appid", secret)
            .build()

        val newRequest = currentRequest.newBuilder().url(url).build()

        return chain.proceed(newRequest)
    }
}
