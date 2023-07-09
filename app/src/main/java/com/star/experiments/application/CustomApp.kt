package com.star.experiments.application

import android.app.Application
import com.facebook.flipper.core.FlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.star.coreandroid.storage.preferences.AppPreferences
import com.star.coreandroid.storage.preferences.di.preferencesDeps
import com.star.corekotlin.provider.dispatcher.dispatcherProviderDeps
import com.star.experiments.application.dsl.configureApp
import com.star.network.di.networkDeps
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class CustomApp : Application() {

    private val networkFlipperPlugin: NetworkFlipperPlugin by inject()
    override fun onCreate() {
        super.onCreate()
        configureApp {
            startKoin()
            context = applicationContext
            configureFlipper = {
                app = this@CustomApp
                pluginsProducer = { flipperPluginsProducer() }
            }
        }
    }

    private fun Application.startKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(
                coreDependencies
            )
        }
    }

    private fun flipperPluginsProducer(): List<FlipperPlugin> =
        listOf(
            InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()),
            networkFlipperPlugin,
            SharedPreferencesFlipperPlugin(this, AppPreferences.name)
        )

    private val coreDependencies: List<Module>
        get() = listOf(
            networkDeps,
            dispatcherProviderDeps,
            preferencesDeps
        )
}
