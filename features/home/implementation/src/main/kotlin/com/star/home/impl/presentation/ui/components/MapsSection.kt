package com.star.home.impl.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.star.designsystem.dimensions.size120
import com.star.designsystem.dimensions.size32
import com.star.designsystem.dimensions.size4

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
