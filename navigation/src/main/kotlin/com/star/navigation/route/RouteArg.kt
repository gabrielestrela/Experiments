package com.star.navigation.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType

interface RouteArg {
    fun routeArgs(): List<NamedNavArgument>
}
