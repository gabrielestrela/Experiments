package com.star.navigation.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument

interface Route {
    val path: String
    val args: List<NamedNavArgument>
}
