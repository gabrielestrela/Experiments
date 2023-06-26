package com.star.home.impl.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.star.designsystem.color.getColorScheme
import com.star.designsystem.dimensions.font64
import com.star.designsystem.dimensions.size120
import com.star.designsystem.dimensions.size16
import com.star.designsystem.dimensions.size2
import com.star.designsystem.dimensions.size24
import com.star.designsystem.dimensions.size32
import com.star.designsystem.dimensions.size4
import com.star.designsystem.dimensions.size64
import com.star.designsystem.dimensions.size8
import com.star.designsystem.extensions.asPainter
import com.star.designsystem.theme.ExperimentTheme
import com.star.experiments.designsystem.R.drawable.*
import com.star.home.impl.domain.model.Period
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
//            item { MapsSection() }
            }
        }
    }
}


@Composable
fun MapsSection() {
    Card(
        modifier = Modifier
            .padding(size32)
            .fillMaxWidth()
            .height(size120),
        elevation = CardDefaults.cardElevation(defaultElevation = size4),
    ) {
    }
}

@Composable
fun ForecastSection() {
    Column {
        Row(Modifier.padding(top = size24)) {
            CustomTab(isSelected = true) { Period.TODAY.description }
            Spacer(modifier = Modifier.padding(end = size16))
            CustomTab(isSelected = false) { Period.TOMORROW.description }
            Spacer(modifier = Modifier.padding(end = size8))
            CustomTab(isSelected = false) { Period.NEXT_10_DAY.description }
        }
        ForecastCardSection()
    }

}

@Composable
fun ForecastCardSection() {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(top = size16)) {
        item {
            ForecastCard(hour = "10am", res = sun_svgrepo, temperature = "16°")
        }
        item {
            ForecastCard(hour = "11am", res = cloud_rain_svgrepo, temperature = "18°")
        }
        item {
            ForecastCard(hour = "12pm", res = clouds_storm_svgrepo, temperature = "20°")
        }
        item {
            ForecastCard(hour = "13pm", res = cloud_rain_svgrepo, temperature = "22°")
        }
        item {
            ForecastCard(hour = "14pm", res = sun_svgrepo, temperature = "22°")
        }
    }
}

@Composable
fun ForecastCard(hour: String, @DrawableRes res: Int, temperature: String) {
    Card(
        modifier = Modifier.padding(end = size16),
        elevation = CardDefaults.cardElevation(defaultElevation = size4)
    ) {
        Column(Modifier.padding(horizontal = size24, vertical = size24)) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = size8),
                text = hour,
                style = MaterialTheme.typography.headlineSmall,
            )
            Icon(
                painter = res.asPainter(),
                contentDescription = "Wind",
                modifier = Modifier
                    .size(size24)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = size8)
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "16°",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TopHeader() {
    Row(Modifier.fillMaxWidth()) {
        Column(Modifier.fillMaxWidth(.5f)) {
            Text(
                text = "Cidade",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(top = size4),
                text = "12 Setembro, Domingo",
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Top), horizontalAlignment = Alignment.End) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = size4),
            ) {
                Icon(
                    painter = squares_four_fill_svgrepo.asPainter(),
                    contentDescription = "Home screen navigation button",
                    modifier =
                    Modifier
                        .align(Alignment.End)
                        .padding(size4)
                        .alpha(1f)
                        .size(size24),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
fun TemperatureSection() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = size32)
    ) {
        Column(Modifier.fillMaxWidth(.5f)) {
            Text(
                text = "18°",
                style = MaterialTheme.typography.titleLarge,
                fontSize = font64
            )
            Text(
                text = "Thunderstorm",
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        Column(
            Modifier
                .fillMaxWidth(1f)
                .align(alignment = Alignment.CenterVertically)) {
            Box(
                modifier = Modifier.align(alignment = Alignment.End)
            ) {
                Image(
                    colorFilter = if(isSystemInDarkTheme()) {
                        ColorFilter.tint(Color.White)
                    } else ColorFilter.tint(Color.Black),
                    painter = thunderstorm_clouds_svgrepo.asPainter(),
                    contentDescription = "Thuderstorm",
                    modifier = Modifier
                        .size(72.dp)
                        .align(alignment = Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun EnvironmentSection() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = size4),
        modifier = Modifier
            .fillMaxWidth()
//            .height(IntrinsicSize.Max)
            .padding(vertical = size16)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = size24)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(Modifier.align(Alignment.CenterVertically)) {
                Icon(
                    painter = wind_svgrepo.asPainter(),
                    contentDescription = "Wind",
                    modifier = Modifier
                        .size(size24)
                        .align(alignment = Alignment.CenterHorizontally)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "10m/s",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Wind",
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
            Column(Modifier.align(Alignment.CenterVertically)) {
                Icon(
                    painter = water_drop_svgrepo.asPainter(),
                    contentDescription = "Wind",
                    modifier = Modifier
                        .size(size24)
                        .align(alignment = Alignment.CenterHorizontally)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "98%",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Humidity",
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
            Column(Modifier.align(Alignment.CenterVertically)) {
                Icon(
                    painter = cloud_rain_svgrepo.asPainter(),
                    contentDescription = "Wind",
                    modifier = Modifier
                        .size(size24)
                        .align(alignment = Alignment.CenterHorizontally)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "100%",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Rain",
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
        }
    }
}

@Composable
fun BottomNavBar() {
    Box(
        Modifier
            .shadow(size2)
            .background(MaterialTheme.colorScheme.background)
            .height(size64)
            .fillMaxWidth()
            .padding(horizontal = size16)
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
            Icon(
                imageVector = imageVector,
                contentDescription = "Home screen navigation button",
                modifier =
                Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .aspectRatio(matchHeightConstraintsFirst = true, ratio = .5f)
                    .padding(size4)
                    .alpha(1f)
                    .size(size24),
                tint = MaterialTheme.colorScheme.onPrimary
            )
    }
}

@Composable
fun CustomTab(isSelected: Boolean = false, text: () -> String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = text(),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Light
        )
        if (isSelected) {
            Spacer(modifier = Modifier.padding(top = size2))
            Canvas(modifier = Modifier.size(size4)) {
                drawCircle(Color.Black)
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

@Preview(showBackground = true)
@Composable
fun PreviewCustomTabItem() {
    ExperimentTheme {
        Row() {
            CustomTab(isSelected = true) { "Today" }
            Spacer(Modifier.padding(end = size8))
            CustomTab { "Tomorrow" }
        }
    }
}