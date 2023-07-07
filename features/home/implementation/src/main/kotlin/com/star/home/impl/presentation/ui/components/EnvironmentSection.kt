package com.star.home.impl.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.star.designsystem.dimensions.size16
import com.star.designsystem.dimensions.size24
import com.star.designsystem.dimensions.size4
import com.star.designsystem.extensions.asPainter
import com.star.experiments.designsystem.R


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
                    painter = R.drawable.wind_svgrepo.asPainter(),
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
                    painter = R.drawable.water_drop_svgrepo.asPainter(),
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
                    painter = R.drawable.cloud_rain_svgrepo.asPainter(),
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
