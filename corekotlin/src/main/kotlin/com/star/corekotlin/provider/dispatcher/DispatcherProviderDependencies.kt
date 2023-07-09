package com.star.corekotlin.provider.dispatcher

import org.koin.dsl.module

val dispatcherProviderDeps = module {
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}
