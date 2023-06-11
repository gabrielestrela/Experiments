package com.star.designsystem.color

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

internal val lightColorScheme = lightColorScheme(
    primary = Color(0xFF5DBB63),
    inversePrimary = Color(0xFF4BAC56),
    secondary = Color(0xFF8EDC8C),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFF424242),
    surfaceVariant = Color(0xFFE0E0E0),
    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFF000000),
    onSurface = Color(0xFF000000),
)

internal val darkColorScheme = darkColorScheme(
    primary = Color(0xFF5DBB63),
    inversePrimary = Color(0xFF4BAC56),
    secondary = Color(0xFF8EDC8C),
    background = Color(0xFF121212),
    surface = Color(0xFF424242),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF),
)

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
internal fun hasSupportForDynamicColor() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

@Composable
internal fun themeColorScheme(supportDynamicColor: Boolean = false) = if (supportDynamicColor) {
    when {
        hasSupportForDynamicColor() &&
                isSystemInDarkTheme() -> dynamicDarkColorScheme(LocalContext.current)
        hasSupportForDynamicColor() &&
                !isSystemInDarkTheme() -> dynamicLightColorScheme(LocalContext.current)
        else -> getColorScheme()
    }
} else getColorScheme()

@Composable
private fun getColorScheme() = if (isSystemInDarkTheme()) darkColorScheme else lightColorScheme
