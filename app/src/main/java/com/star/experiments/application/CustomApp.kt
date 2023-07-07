package com.star.experiments.application

import android.app.Application
import com.star.network.di.networkDeps
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                networkDeps
            )
        }
    }
}
