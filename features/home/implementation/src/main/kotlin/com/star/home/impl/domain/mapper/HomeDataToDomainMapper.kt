package com.star.home.impl.domain.mapper

import com.star.corekotlin.date.DatePattern
import com.star.corekotlin.date.fromMillisToFormatted
import com.star.corekotlin.mapper.Mapper
import com.star.corekotlin.primitives.floats.extension.orZero
import com.star.corekotlin.primitives.integer.extension.orZero
import com.star.home.impl.data.model.response.HomeResponse
import com.star.home.impl.domain.model.EnvironmentSectionData
import com.star.home.impl.domain.model.HeaderSection
import com.star.home.impl.domain.model.HomeData
import com.star.home.impl.domain.model.HourlyForecastData
import com.star.home.impl.domain.model.TemperatureSectionData

class HomeDataToDomainMapper : Mapper<HomeResponse, HomeData> {
    override fun mapFrom(from: HomeResponse): HomeData =
        HomeData(
            headerSection = HeaderSection(
                cityName = from.timeZone?.split("/")?.last().orEmpty(),
                date = from.currentWeather?.date?.fromMillisToFormatted().orEmpty()
            ),
            temperatureSection = TemperatureSectionData(
                temperature = from.currentWeather?.temperature.orZero().toString(),
                description = from.currentWeather?.weatherInfo?.description.orEmpty(),
                weatherIcon = from.currentWeather?.weatherInfo?.icon.orEmpty()
            ),
            environmentSection = EnvironmentSectionData(
                windSpeed = from.currentWeather?.windSpeed.orZero().toString(),
                humidity = from.currentWeather?.humidity.orZero().toString(),
                clouds = from.currentWeather?.clouds.orZero().toString()
            ),
            forecastSection = from.hourlyForecast?.map {
                HourlyForecastData(
                    date = it.date
                        ?.fromMillisToFormatted(datePattern = DatePattern.HOUR_AM_PM)
                        .orEmpty(),
                    weatherIcon = it.weather?.icon.orEmpty(),
                    temperature = it.temperature.orZero().toString()
                )
            } ?: listOf()
        )
}
