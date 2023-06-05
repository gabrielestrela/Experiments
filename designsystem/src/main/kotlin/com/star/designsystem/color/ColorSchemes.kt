package com.star.designsystem.color

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// TODO (needs definition)
internal val lightColorScheme = lightColorScheme(

)

// TODO (needs definition)
internal val darkColorScheme = darkColorScheme(

)

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
internal fun hasSupportForDynamicColor() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

@Composable
internal fun themeColorScheme() = when {
    hasSupportForDynamicColor() &&
            isSystemInDarkTheme() -> dynamicDarkColorScheme(LocalContext.current)
    hasSupportForDynamicColor() &&
            !isSystemInDarkTheme() -> dynamicLightColorScheme(LocalContext.current)
    isSystemInDarkTheme() -> darkColorScheme
    else -> lightColorScheme
}
