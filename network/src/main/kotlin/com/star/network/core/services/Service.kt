package com.star.network.core.services

import com.star.corekotlin.primitives.string.extension.empty

interface Service {
    val koinName: String
    val interceptorName: String
    val secret: String
    val baseUrl: String
}