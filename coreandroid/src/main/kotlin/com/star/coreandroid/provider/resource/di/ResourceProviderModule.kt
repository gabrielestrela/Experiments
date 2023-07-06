package com.star.coreandroid.provider.resource.di

import com.star.coreandroid.provider.resource.ResourceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val resourceProviderModule = module {
    factory { ResourceProvider(context = androidContext()) }

}