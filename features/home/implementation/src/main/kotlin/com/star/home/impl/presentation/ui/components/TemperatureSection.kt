package com.star.home.impl.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.star.designsystem.dimensions.font64
import com.star.designsystem.dimensions.size32
import com.star.designsystem.extensions.asPainter
import com.star.experiments.designsystem.R

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
                    painter = R.drawable.thunderstorm_clouds_svgrepo.asPainter(),
                    contentDescription = "Thuderstorm",
                    modifier = Modifier
                        .size(72.dp)
                        .align(alignment = Alignment.Center)
                )
            }
        }
    }
}
