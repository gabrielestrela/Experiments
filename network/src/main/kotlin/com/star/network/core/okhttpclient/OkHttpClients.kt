package com.star.network.core.okhttpclient

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.star.network.core.interceptor.AuthInterceptor
import okhttp3.OkHttpClient

fun getCustomClient(
    authInterceptor: AuthInterceptor,
    flipperPlugin: NetworkFlipperPlugin
): OkHttpClient =
    OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(FlipperOkhttpInterceptor(flipperPlugin))
        .build()
