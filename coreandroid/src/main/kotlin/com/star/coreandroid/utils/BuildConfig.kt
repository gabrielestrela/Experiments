package com.star.coreandroid.utils

import android.content.Context
import android.content.pm.ApplicationInfo


private fun Context.isDebug() =
    (this.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0)

fun Context.runIfDebug(block: () -> Unit) {
    if (this.isDebug()) block()
}
