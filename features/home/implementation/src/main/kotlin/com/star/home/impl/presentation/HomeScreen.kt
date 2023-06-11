package com.star.home.impl.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.star.designsystem.extensions.asDimen
import com.star.designsystem.theme.ExperimentTheme
import com.star.experiments.designsystem.R.*
import com.star.experiments.designsystem.R.dimen.*
import com.star.experiments.home.impl.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BottomNavBar() }
    ) { padding ->
        Box() {
            padding
        }
    }
}

@Composable
fun BottomNavBar() {
    Box(
        Modifier
            .shadow(size2.asDimen())
            .background(MaterialTheme.colorScheme.background)
            .height(size64.asDimen())
            .fillMaxWidth()
            .padding(horizontal = size16.asDimen())
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.weight(1.5f),
                contentAlignment = Alignment.Center
            ) {
                BottomNavItem(Icons.Outlined.CheckCircle)
            }
            Box(
                Modifier.weight(1.5f),
                contentAlignment = Alignment.Center
            ) {
                BottomNavItem()
            }
            Box(
                Modifier.weight(1.5f),
                contentAlignment = Alignment.Center
            ) {
                BottomNavItem(Icons.Outlined.Person)
            }
        }
    }
}

@Composable
fun BottomNavItem(
    imageVector: ImageVector = Icons.Filled.Home
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            Modifier.height(size32.asDimen()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = "Home screen navigation button",
                modifier =
                Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight()
                    .padding(start = size8.asDimen())
                    .alpha(1f)
                    .size(size24.asDimen()),
                tint = MaterialTheme.colorScheme.surface
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    ExperimentTheme {
        HomeScreen()
    }
}