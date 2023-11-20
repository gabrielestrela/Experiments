package com.star.home.impl.presentation.viewstate

import androidx.annotation.DrawableRes
import com.star.corekotlin.primitives.string.extension.empty

data class HomeViewState(
    val topHeader: TopHeader = TopHeader(),
    val temperatureSection: TemperatureSection = TemperatureSection(),
    val environmentSection: EnvironmentSection = EnvironmentSection(),
    val forecastSection: ForecastSection = ForecastSection(),
    val isError: Boolean = false,
)

data class TopHeader(
    val city: String = String.empty(),
    val date: String = String.empty(),
)

data class TemperatureSection(
    val temperature: String = String.empty(),
    val weatherDescription: String = String.empty(),
    @DrawableRes val weatherTypeIcon: Int = 0,
)

data class EnvironmentSection(
    val wind: EnvironmentDetails = EnvironmentDetails(),
    val humidity: EnvironmentDetails = EnvironmentDetails(),
    val clouds: EnvironmentDetails = EnvironmentDetails()
)

data class EnvironmentDetails(
    @DrawableRes val iconRes: Int = 0,
    val value: String = String.empty(),
    val label: String = String.empty()
)

data class ForecastSection(
    val tabs: List<ForecastTab> = listOf(),
    val tabContent: Map<ForecastPeriod, List<ForecastDetail>> = mapOf()
)

data class ForecastTab(
    val period: ForecastPeriod = ForecastPeriod.TODAY,
    val isSelected: Boolean = false
)

enum class ForecastPeriod(val label: String) {
    TODAY("Today"),
    TOMORROW("Tomorrow"),
    NEXT_10("Next 10 Days"),
    NEXT_15("Next 15 Days"),
}

sealed class ForecastDetail {
    data class Today(
        val time: String = String.empty(),
        @DrawableRes val icon: Int = 0,
        val temperature: String = String.empty()
    ) : ForecastDetail()

    object NextDays: ForecastDetail()
}
