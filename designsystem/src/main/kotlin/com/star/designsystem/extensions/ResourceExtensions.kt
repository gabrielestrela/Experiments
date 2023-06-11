package com.star.designsystem.extensions

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp

@Composable
fun Int.asDimen(): Dp = dimensionResource(id = this)

@Composable
fun Int.asString(): String = stringResource(id = this)

