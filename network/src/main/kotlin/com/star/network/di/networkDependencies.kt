package com.star.network.di

import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.star.network.core.interceptor.AuthInterceptor
import com.star.network.core.okhttpclient.getCustomClient
import com.star.network.core.services.Services
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkDeps = module {
    single(named(Services.weatherService.interceptorName)) {
        AuthInterceptor(secret = Services.weatherService.secret)
    }

    single(named(Services.spotifyService.interceptorName)) {
        AuthInterceptor(secret = Services.spotifyService.secret)
    }

    single { NetworkFlipperPlugin() }

    single(named(Services.weatherService.koinName)) {
        Retrofit.Builder()
            .baseUrl(Services.weatherService.baseUrl)
            .client(
                getCustomClient(
                    authInterceptor = get(named(Services.weatherService.interceptorName)),
                    flipperPlugin = get()
                )
            )
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single(named(Services.spotifyService.koinName)) {
        Retrofit.Builder()
            .baseUrl(Services.spotifyService.baseUrl)
            .client(
                getCustomClient(
                    authInterceptor = get(named(Services.spotifyService.interceptorName)),
                    flipperPlugin = get()
                )
            )
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}
