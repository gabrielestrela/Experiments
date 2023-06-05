package com.star.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.star.designsystem.color.themeColorScheme
import com.star.designsystem.shape.experimentsShapes
import com.star.designsystem.typography.experimentsTypography

@Composable
fun ExperimentTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = themeColorScheme(),
        typography = experimentsTypography,
        shapes = experimentsShapes,
        content = content
    )
}
