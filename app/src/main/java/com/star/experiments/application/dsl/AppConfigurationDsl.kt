package com.star.experiments.application.dsl

import android.app.Application
import android.content.Context
import com.facebook.flipper.core.FlipperPlugin

data class AppConfigurationDsl(
    var context: Context? = null,
    var configureFlipper: (FlipperConfigurationDsl.() -> Unit)? = null
)

data class FlipperConfigurationDsl(
    var app: Application? = null,
    var pluginsProducer: (() -> List<FlipperPlugin>)? = null
)
