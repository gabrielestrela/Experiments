package com.star.designsystem.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.star.designsystem.extensions.asFont
import com.star.experiments.designsystem.R

val experimentsTypography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.2.sp,
        fontFamily = FontFamily(R.font.russooneregular.asFont())
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
        fontFamily = FontFamily(R.font.russooneregular.asFont())
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.1.sp,
        lineHeight = 22.sp,
        fontFamily = FontFamily(R.font.russooneregular.asFont())
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(R.font.russooneregular.asFont())
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(R.font.russooneregular.asFont())
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(R.font.russooneregular.asFont())
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(R.font.russooneregular.asFont())
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(R.font.chakrapetchregular.asFont())
    )
)