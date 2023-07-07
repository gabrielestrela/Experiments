package com.star.coreandroid.utils

import org.koin.android.BuildConfig

inline fun runIfDebug(block: () -> Unit) {
    if (BuildConfig.DEBUG) block()
}
