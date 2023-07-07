package com.star.home.impl.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.star.designsystem.color.getColorScheme
import com.star.designsystem.dimensions.size32
import com.star.designsystem.theme.ExperimentTheme
import com.star.home.impl.presentation.ui.components.EnvironmentSection
import com.star.home.impl.presentation.ui.components.ForecastSection
import com.star.home.impl.presentation.ui.components.MapsSection
import com.star.home.impl.presentation.ui.components.TemperatureSection
import com.star.home.impl.presentation.ui.components.TopHeader
import com.star.home.impl.presentation.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    Surface() {
        Scaffold(
            bottomBar = { MapsSection() }
        ) { padding ->
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(size32)
            ) {
                item { TopHeader() }
                item { TemperatureSection() }
                item { EnvironmentSection() }
                item { ForecastSection() }
            }
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

@Preview
@Composable
fun PreviewHomeScreenDark() {
    ExperimentTheme(colorScheme = getColorScheme(true)) {
        HomeScreen()
    }
}
