package com.star.experiments.application

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.core.FlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import com.star.coreandroid.storage.preferences.AppPreferences
import com.star.coreandroid.storage.preferences.di.preferencesDeps
import com.star.coreandroid.utils.runIfDebug
import com.star.network.di.networkDeps
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApp : Application() {

    private val networkFlipperPlugin: NetworkFlipperPlugin by inject()
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                preferencesDeps,
                networkDeps
            )
        }
        setupFlipper()
    }

    private fun Application.setupFlipper() {
        runIfDebug {
            SoLoader.init(this, false)
            if (FlipperUtils.shouldEnableFlipper(this)) {
                AndroidFlipperClient.getInstance(this).also { client ->
                    getFlipperPlugins().forEach { client.addPlugin(it) }
                    client.start()
                }
            }
        }
    }

    private fun Application.getFlipperPlugins(): List<FlipperPlugin> =
        listOf(
            InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()),
            networkFlipperPlugin,
            SharedPreferencesFlipperPlugin(this, AppPreferences.name)
        )
}
