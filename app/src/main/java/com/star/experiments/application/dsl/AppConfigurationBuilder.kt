package com.star.experiments.application.dsl

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.soloader.SoLoader
import com.star.coreandroid.utils.runIfDebug

inline fun Application.configureApp(crossinline initBlock: AppConfigurationDsl.() -> Unit) {
    val dsl = AppConfigurationDsl()
    dsl.initBlock()

    with(dsl) {
        configureFlipper?.let { configureFlipper(it) }
    }

}

fun configureFlipper(flipperConfig: FlipperConfigurationDsl.() -> Unit) {
    val dsl = FlipperConfigurationDsl()
    dsl.flipperConfig()

    dsl.app?.runIfDebug {
        SoLoader.init(dsl.app, false)
        if (FlipperUtils.shouldEnableFlipper(dsl.app)) {
            val client = AndroidFlipperClient.getInstance(dsl.app)
            dsl.pluginsProducer?.invoke()?.forEach { client.addPlugin(it) }
            client.start()
        }
    }
}
