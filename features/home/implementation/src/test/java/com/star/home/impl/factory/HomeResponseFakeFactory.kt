package com.star.home.impl.factory

import com.star.corekotlin.primitives.string.extension.empty
import com.star.home.impl.data.model.response.CurrentWeatherResponse
import com.star.home.impl.data.model.response.HomeResponse
import com.star.home.impl.data.model.response.HourlyForecastResponse
import com.star.home.impl.data.model.response.WeatherInfoResponse

fun makeHomeResponseFake(
    timeZone: String = String.empty(),
    currentWeather: CurrentWeatherResponse = makeCurrentWeatherResponseFake(),
    hourlyForecast: List<HourlyForecastResponse> = listOf(makeHourlyForecastResponse())
) = HomeResponse(
    timeZone = timeZone,
    currentWeather = currentWeather,
    hourlyForecast = hourlyForecast
)

fun makeHourlyForecastResponse(
    date: Long = 0,
    weather: WeatherInfoResponse = makeWeatherInfoResponseFake(),
    temperature: Float = 0F
) = HourlyForecastResponse(
    date = date,
    weather = weather,
    temperature = temperature
)

fun makeWeatherInfoResponseFake(
    id: Int = 0,
    type: String = String.empty(),
    description: String = String.empty(),
    icon: String = String.empty()
) = WeatherInfoResponse(
    id = id,
    type = type,
    description = description,
    icon = icon
)

fun makeCurrentWeatherResponseFake(
    date: Long = 0,
    temperature: Float = 0F,
    weatherInfo:WeatherInfoResponse = makeWeatherInfoFakeResponse(),
    windSpeed: Float = 0F,
    humidity: Int = 0,
    clouds: Int = 0
) = CurrentWeatherResponse(
    date = date,
    temperature = temperature,
    weatherInfo = weatherInfo,
    windSpeed = windSpeed,
    humidity = humidity,
    clouds = clouds
)

fun makeWeatherInfoFakeResponse(
    id: Int = 0,
    type: String = String.empty(),
    description: String = String.empty(),
    icon: String = String.empty()
) = WeatherInfoResponse(
    id = id,
    type = type,
    description = description,
    icon = icon
)
