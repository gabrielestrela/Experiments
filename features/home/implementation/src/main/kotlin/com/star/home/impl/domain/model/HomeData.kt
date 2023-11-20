package com.star.home.impl.domain.model

import com.star.corekotlin.primitives.string.extension.empty

data class HomeData(
    val headerSection: HeaderSection = HeaderSection(),
    val temperatureSection: TemperatureSectionData = TemperatureSectionData(),
    val environmentSection: EnvironmentSectionData = EnvironmentSectionData(),
    val forecastSection: List<HourlyForecastData> = listOf(),
)

data class HeaderSection(
    val cityName: String = String.empty(),
    val date: String = String.empty(),
)

data class TemperatureSectionData(
    val temperature: String = String.empty(),
    val description: String = String.empty(),
    val weatherIcon: String = String.empty()
)

data class EnvironmentSectionData(
    val windSpeed: String = String.empty(),
    val humidity: String = String.empty(),
    val clouds: String = String.empty()
)

data class HourlyForecastData(
    val date: String = String.empty(),
    val weatherIcon: String = String.empty(),
    val temperature: String = String.empty()
)
