package com.star.coreandroid.storage.preferences.di

import com.star.coreandroid.storage.preferences.AppPreferences
import com.star.coreandroid.storage.preferences.Preferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesDeps = module {
    single<Preferences> { AppPreferences(androidContext()) }
}
