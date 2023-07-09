package com.star.home.impl.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    @Json(name = "timezone") val timeZone: String? = null,
    @Json(name = "current") val currentWeather: CurrentWeatherResponse? = null,
    @Json(name = "hourly") val hourlyForecast: List<HourlyForecastResponse>? = null
)

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
    @Json(name = "dt") val date: Long? = null,
    @Json(name = "temp") val temperature: Float? = null,
    @Json(name = "weather") val weatherInfo: WeatherInfoResponse? = null,
    @Json(name = "wind_speed") val windSpeed: Float? = null,
    @Json(name = "humidity") val humidity: Int? = null,
    @Json(name = "clouds") val clouds: Int? = null,
)

@JsonClass(generateAdapter = true)
data class WeatherInfoResponse(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "main") val type: String? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "icon") val icon: String? = null,
)

@JsonClass(generateAdapter = true)
data class HourlyForecastResponse(
    @Json(name = "dt") val date: Long? = null,
    @Json(name = "weather") val weather: WeatherInfoResponse? = null,
    @Json(name = "temp") val temperature: Float? = null,
)
