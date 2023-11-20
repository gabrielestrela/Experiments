package com.star.home.impl.factory

import com.star.corekotlin.primitives.string.extension.empty
import com.star.home.impl.presentation.viewstate.EnvironmentDetails
import com.star.home.impl.presentation.viewstate.EnvironmentSection
import com.star.home.impl.presentation.viewstate.ForecastDetail
import com.star.home.impl.presentation.viewstate.ForecastPeriod
import com.star.home.impl.presentation.viewstate.ForecastSection
import com.star.home.impl.presentation.viewstate.ForecastTab
import com.star.home.impl.presentation.viewstate.HomeViewState
import com.star.home.impl.presentation.viewstate.TemperatureSection
import com.star.home.impl.presentation.viewstate.TopHeader

fun makeHomeViewStateFake(
    topHeader: TopHeader = makeTopHeader(),
    temperatureSection: TemperatureSection = makeTemperatureSection(),
    environmentSection: EnvironmentSection = makeEnvironmentSection(),
    forecastSection: ForecastSection = makeForecastSection(),
    isError: Boolean = false
) = HomeViewState(
    topHeader = topHeader,
    temperatureSection = temperatureSection,
    environmentSection = environmentSection,
    forecastSection = forecastSection,
    isError = isError
)

fun makeForecastSection(
    tabs: List<ForecastTab> = listOf(makeForecastTab()),
    tabContent: Map<ForecastPeriod, List<ForecastDetail>> = mapOf(makeTabContent())
) = ForecastSection(
    tabs = tabs,
    tabContent = tabContent,
)

fun makeTabContent(
    forecastPeriod: ForecastPeriod = ForecastPeriod.TODAY,
    foreCastDetails: List<ForecastDetail> = listOf(makeForecastDetail())
): Pair<ForecastPeriod, List<ForecastDetail>> = Pair(
    forecastPeriod,
    foreCastDetails
)

fun makeForecastDetail(
    time: String = String.empty(),
    icon: Int = 0,
    temperature: String = String.empty()
) = ForecastDetail.Today(
    time = time,
    icon = icon,
    temperature = temperature
)

fun makeForecastTab(
    period: ForecastPeriod = ForecastPeriod.TODAY,
    isSelected: Boolean = false
) = ForecastTab(
    period = period,
    isSelected = isSelected
)

fun makeEnvironmentSection(
    wind: EnvironmentDetails = makeEnvironmentDetails(),
    humidity: EnvironmentDetails = makeEnvironmentDetails(),
    clouds: EnvironmentDetails = makeEnvironmentDetails()
) = EnvironmentSection(
    wind = wind,
    humidity = humidity,
    clouds = clouds,
)

fun makeEnvironmentDetails(
    iconRes: Int = 0,
    value: String = String.empty(),
    label: String = String.empty()
) = EnvironmentDetails(
    iconRes = iconRes,
    value = value,
    label = label
)

fun makeTemperatureSection(
    temperature: String = String.empty(),
    weatherDescription: String = String.empty(),
    weatherTypeIcon: Int = 0
) = TemperatureSection(
    temperature = temperature,
    weatherDescription = weatherDescription,
    weatherTypeIcon = weatherTypeIcon
)

fun makeTopHeader(
    city: String = String.empty(),
    date: String = String.empty()
) = TopHeader(
    city = city,
    date = date
)
