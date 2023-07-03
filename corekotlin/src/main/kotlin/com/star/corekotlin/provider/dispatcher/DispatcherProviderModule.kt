package com.star.corekotlin.provider.dispatcher

import org.koin.dsl.module

val dispatcherProviderModule = module {
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}