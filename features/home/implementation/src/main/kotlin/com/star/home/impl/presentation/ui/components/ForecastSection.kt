package com.star.home.impl.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.star.designsystem.dimensions.size16
import com.star.designsystem.dimensions.size2
import com.star.designsystem.dimensions.size24
import com.star.designsystem.dimensions.size4
import com.star.designsystem.dimensions.size8
import com.star.designsystem.extensions.asPainter
import com.star.designsystem.theme.ExperimentTheme
import com.star.experiments.designsystem.R
import com.star.home.impl.domain.model.Period

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
            ForecastCard(hour = "10am", res = R.drawable.sun_svgrepo, temperature = "16°")
        }
        item {
            ForecastCard(hour = "11am", res = R.drawable.cloud_rain_svgrepo, temperature = "18°")
        }
        item {
            ForecastCard(hour = "12pm", res = R.drawable.clouds_storm_svgrepo, temperature = "20°")
        }
        item {
            ForecastCard(hour = "13pm", res = R.drawable.cloud_rain_svgrepo, temperature = "22°")
        }
        item {
            ForecastCard(hour = "14pm", res = R.drawable.sun_svgrepo, temperature = "22°")
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
