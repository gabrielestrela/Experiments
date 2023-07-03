package com.star.corekotlin.provider.dispatcher

import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {
    fun io() = Dispatchers.IO
    fun main() = Dispatchers.Main
    fun default() = Dispatchers.Default
    fun unconfined() = Dispatchers.Unconfined
}

class DefaultDispatcherProvider : DispatcherProvider