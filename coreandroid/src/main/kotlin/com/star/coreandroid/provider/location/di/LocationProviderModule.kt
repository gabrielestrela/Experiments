package com.star.coreandroid.provider.location.di

import com.star.coreandroid.provider.location.LocationProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val locationProviderModule = module {
    factory {
        LocationProvider(context = androidContext(), resourceProvider = get(), dispatcher = get())
    }
}
