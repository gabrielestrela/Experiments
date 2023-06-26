package com.star.home.impl.presentation.procedure

sealed class HomeProcedure {
    object TopHeaderMenuClick : HomeProcedure()
    object ForecastTabClick : HomeProcedure()
}
