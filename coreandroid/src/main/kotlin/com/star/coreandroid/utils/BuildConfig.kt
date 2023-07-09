package com.star.coreandroid.utils

import android.content.Context
import android.content.pm.ApplicationInfo

// https://medium.com/mobile-app-development-publication/checking-debug-build-the-right-way-d12da1098120
private fun Context.isDebug() =
    (this.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0)

fun Context.runIfDebug(block: () -> Unit) {
    if (this.isDebug()) block()
}
