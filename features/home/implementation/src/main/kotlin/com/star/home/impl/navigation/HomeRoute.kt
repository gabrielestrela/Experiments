package com.star.home.impl.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.star.navigation.route.Route
import com.star.navigation.route.RouteArg

class HomeRoute : Route {
    override val path: String
        get() = "HomeScreenRoute"
    override val args: List<NamedNavArgument>
        get() = listOf(
            navArgument("Teste") {
                type = NavType.StringType
            },
            navArgument("TesteInt") {
                type = NavType.IntType
            }
        )
}