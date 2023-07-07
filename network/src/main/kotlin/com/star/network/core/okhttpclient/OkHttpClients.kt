package com.star.network.core.okhttpclient

import com.star.network.core.interceptor.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit

fun getCustomClient(authInterceptor: AuthInterceptor): OkHttpClient =
    OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
