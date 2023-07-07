package com.star.experiments.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.star.designsystem.theme.ExperimentTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Composable
fun ExperimentApp() {
    ExperimentTheme {
    }
}

@Composable
fun NavigationApp() {
    // Do Nothing
}
