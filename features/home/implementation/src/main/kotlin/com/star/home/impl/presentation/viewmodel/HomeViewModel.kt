package com.star.home.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.star.corekotlin.flow.handleErrors
import com.star.corekotlin.provider.dispatcher.DispatcherProvider
import com.star.home.impl.domain.model.HomeData
import com.star.home.impl.domain.usecase.GetHomeDataUseCase
import com.star.home.impl.presentation.action.HomeAction
import com.star.home.impl.presentation.procedure.HomeProcedure
import com.star.home.impl.presentation.viewstate.EnvironmentDetails
import com.star.home.impl.presentation.viewstate.EnvironmentSection
import com.star.home.impl.presentation.viewstate.ForecastDetail
import com.star.home.impl.presentation.viewstate.ForecastPeriod
import com.star.home.impl.presentation.viewstate.ForecastSection
import com.star.home.impl.presentation.viewstate.ForecastTab
import com.star.home.impl.presentation.viewstate.HomeViewState
import com.star.home.impl.presentation.viewstate.TemperatureSection
import com.star.home.impl.presentation.viewstate.TopHeader
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val dispatcher: DispatcherProvider,
    private val getHomeData: GetHomeDataUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    private val _action: Channel<HomeAction> = Channel()
    val action = _action.consumeAsFlow()

    init {
        fetchHomeData()
    }

    fun executeProcedure(procedure: HomeProcedure) = when (procedure) {
        is HomeProcedure.TopHeaderMenuClick -> handleTopHeaderMenuClick()
        is HomeProcedure.ForecastTabClick -> handleForecastTabClick()
    }

    private fun handleForecastTabClick() {
        // Do Nothing
    }

    private fun handleTopHeaderMenuClick() {
        // Do Nothing
    }

    private fun fetchHomeData() {
        viewModelScope.launch(dispatcher.io()) {
            getHomeData()
                .onEach { data ->
                    _state.update { updateStateWithData(data) }
                }.handleErrors { throwable ->
                    _state.update { _state.value.copy(isError = true) }
                }
        }
    }

    private fun updateStateWithData(newData: HomeData): HomeViewState =
        _state.value.copy(
            topHeader = TopHeader(
                city = newData.headerSection.cityName,
                date = newData.headerSection.date,
            ),
            temperatureSection = TemperatureSection(
                temperature = newData.temperatureSection.temperature,
                weatherDescription = newData.temperatureSection.description,
                // TODO map icons
            ),
            environmentSection = EnvironmentSection(
                wind = EnvironmentDetails(
                    value = newData.environmentSection.windSpeed,
                ),
                humidity = EnvironmentDetails(
                    value = newData.environmentSection.humidity
                ),
                clouds = EnvironmentDetails(
                    value = newData.environmentSection.clouds
                )
            ),
            forecastSection = ForecastSection(
                tabs = listOf(ForecastTab()),
                tabContent = mapOf(
                    ForecastPeriod.TODAY to newData.forecastSection.map {
                       ForecastDetail.Today(
                           time = it.date,
                           //TODO add icon
                           temperature = it.temperature
                       )
                    }
                )
            )
        )
}
