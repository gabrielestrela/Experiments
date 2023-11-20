package com.star.home.impl.presentation.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.star.corekotlin.provider.dispatcher.DispatcherProvider
import com.star.home.impl.domain.model.HomeData
import com.star.home.impl.domain.usecase.GetHomeDataUseCase
import com.star.home.impl.factory.makeHomeDataFake
import com.star.home.impl.factory.makeHomeViewStateFake
import com.star.home.impl.testtools.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val rule = CoroutineTestRule()

    private val dispatcher: DispatcherProvider by lazy { mockk() }
    private val useCase: GetHomeDataUseCase by lazy { mockk() }

    @Test
    fun onViewModelInit_fetchHomeData_returnHomeData() = runTest(rule.testDispatcher) {
        val result = makeHomeDataFake()
        prepareScenario(result)

        val viewModel = viewModel()

        val expected = makeHomeViewStateFake()
        val actual = viewModel.state

        actual.test {
            assertEquals(expected, this.expectMostRecentItem())
        }
    }

    private fun viewModel(
        dispatcher: DispatcherProvider = this.dispatcher,
        useCase: GetHomeDataUseCase = this.useCase
    ) = HomeViewModel(dispatcher, useCase)

    private fun prepareScenario(
        useCaseResult: HomeData = makeHomeDataFake()
    ) {
        coEvery { useCase.invoke() } returns flowOf(useCaseResult)
    }
}
