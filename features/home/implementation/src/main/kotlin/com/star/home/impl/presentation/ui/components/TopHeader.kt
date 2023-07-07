package com.star.home.impl.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.alpha
import com.star.designsystem.dimensions.size24
import com.star.designsystem.dimensions.size4
import com.star.designsystem.extensions.asPainter
import com.star.experiments.designsystem.R

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
                    painter = R.drawable.squares_four_fill_svgrepo.asPainter(),
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
