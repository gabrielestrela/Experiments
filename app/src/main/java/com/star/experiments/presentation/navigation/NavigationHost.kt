package com.star.experiments.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.star.home.impl.navigation.HomeRoute

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    val homeRoute = HomeRoute()

    NavHost(
        navController = navController,
        startDestination = "HomeScreen"
    ) {
        composable(
            homeRoute.path,
            arguments = homeRoute.args
        ) {
        }
    }
}
