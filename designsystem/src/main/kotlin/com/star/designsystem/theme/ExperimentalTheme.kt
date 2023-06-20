package com.star.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.star.designsystem.color.themeColorScheme
import com.star.designsystem.shape.experimentsShapes
import com.star.designsystem.typography.experimentsTypography

@Composable
fun ExperimentTheme(colorScheme: ColorScheme? = null, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colorScheme ?: themeColorScheme(supportDynamicColor = false),
        typography = experimentsTypography,
        shapes = experimentsShapes,
        content = content
    )
}
