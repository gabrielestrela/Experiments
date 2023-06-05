package com.star.network.core.services

import com.star.corekotlin.primitives.string.extension.empty

object Services {
    val weatherService = object : Service {
        override val koinName: String
            get() = "weatherService"
        override val interceptorName: String
            get() = "weatherInterceptor"

        // TODO setup secret via build config field
        override val secret: String
            get() = String.empty()

        // TODO setup base url via build config field
        override val baseUrl: String
            get() = String.empty()

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
