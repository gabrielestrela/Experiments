package com.star.designsystem.extensions

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.star.experiments.designsystem.R

@Composable
fun Int.asDimen(): Dp = dimensionResource(id = this)

@Composable
@ReadOnlyComposable
fun Int.asString(): String = stringResource(id = this)

@Composable
@ReadOnlyComposable
fun Int.asSp(): TextUnit = dimensionResource(id = this).value.sp

@Composable
fun Int.asPainter() = painterResource(id = this)


fun Int.asFont(): Font = Font(this)
