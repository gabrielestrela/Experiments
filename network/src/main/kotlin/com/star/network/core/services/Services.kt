package com.star.network.core.services

import com.star.corekotlin.primitives.string.extension.empty
import com.star.experiments.network.BuildConfig

object Services {
    val weatherService = object : Service {
        override val koinName: String
            get() = "weatherService"
        override val interceptorName: String
            get() = "weatherInterceptor"

        override val secret: String
            get() = BuildConfig.WAPIS

        override val baseUrl: String
            get() = "https://api.openweathermap.org/data/3.0/onecall/"

    }

    val spotifyService = object : Service {
        override val koinName: String
            get() = "spotifyService"
        override val interceptorName: String
            get() = "spotifyInterceptor"

        // TODO setup secret via build config field
        override val secret: String
            get() = String.empty()

        // TODO setup base url via build config field
        override val baseUrl: String
            get() = String.empty()

    }
}
