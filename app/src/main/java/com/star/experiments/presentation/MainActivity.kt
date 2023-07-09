package com.star.experiments.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.star.designsystem.theme.ExperimentTheme
import com.star.home.impl.di.HomeModule
import com.star.home.impl.presentation.ui.HomeScreen
import com.star.home.impl.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : AppCompatActivity() {

    init {
        HomeModule().load()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExperimentApp()
        }
    }
}

@Composable
fun ExperimentApp(homeViewModel: HomeViewModel = koinViewModel()) {
    ExperimentTheme {
        HomeScreen(homeViewModel)
    }
}

@Composable
fun NavigationApp() {
    // Do Nothing
}
