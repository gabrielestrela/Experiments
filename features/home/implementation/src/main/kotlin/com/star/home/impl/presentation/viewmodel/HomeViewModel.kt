package com.star.home.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.star.home.impl.presentation.action.HomeAction
import com.star.home.impl.presentation.procedure.HomeProcedure
import com.star.home.impl.presentation.viewstate.HomeViewState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    private val _action: Channel<HomeAction> = Channel()
    val action = _action.consumeAsFlow()

    fun executeProcedure(procedure: HomeProcedure) = when (procedure) {
        is HomeProcedure.TopHeaderMenuClick -> handleTopHeaderMenuClick()
        is HomeProcedure.ForecastTabClick -> handleForecastTabClick()
    }

    private fun handleForecastTabClick() {
    }

    private fun handleTopHeaderMenuClick() {
    }
}