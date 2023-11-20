package com.star.home.impl.factory

import com.star.corekotlin.primitives.string.extension.empty
import com.star.home.impl.domain.model.EnvironmentSectionData
import com.star.home.impl.domain.model.HeaderSection
import com.star.home.impl.domain.model.HomeData
import com.star.home.impl.domain.model.HourlyForecastData
import com.star.home.impl.domain.model.TemperatureSectionData

fun makeHomeDataFake(
    headerSection: HeaderSection = makeHeaderSection(),
    temperatureSection: TemperatureSectionData = makeTemperatureSectionData(),
    environmentSectionData: EnvironmentSectionData = makeEnvironmentSectionData(),
    forecastSection: List<HourlyForecastData> = listOf(makeHourlyForecastData())
    ) = HomeData(
    headerSection = headerSection,
    temperatureSection = temperatureSection,
    environmentSection = environmentSectionData,
    forecastSection = forecastSection
)

fun makeHourlyForecastData(
    date: String = String.empty(),
    weatherIcon: String = String.empty(),
    temperature: String = String.empty()
) = HourlyForecastData(
    date = date,
    weatherIcon = weatherIcon,
    temperature = temperature
)

fun makeEnvironmentSectionData(
    windSpeed: String = String.empty(),
    humidity: String = String.empty(),
    clouds: String = String.empty()
) = EnvironmentSectionData(
    windSpeed = windSpeed,
    humidity = humidity,
    clouds = clouds
)

fun makeTemperatureSectionData(
    temperature: String = String.empty(),
    description: String = String.empty(),
    weatherIcon: String = String.empty()
) = TemperatureSectionData(
    temperature = temperature,
    description = description,
    weatherIcon = weatherIcon
)

fun makeHeaderSection(
    cityName: String = String.empty(),
    date: String = String.empty()
) = HeaderSection(
    cityName = cityName,
    date = date,
)
