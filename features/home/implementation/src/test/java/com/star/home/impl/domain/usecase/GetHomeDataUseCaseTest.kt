package com.star.home.impl.domain.usecase

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.star.home.impl.data.repository.HomeRepository
import com.star.home.impl.domain.model.HomeData
import com.star.home.impl.factory.makeHomeDataFake
import com.star.home.impl.testtools.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class GetHomeDataUseCaseTest {

    @get:Rule
    val rule = CoroutineTestRule()

    private val repository: HomeRepository by lazy { mockk() }
    private val useCase: GetHomeDataUseCase = GetHomeDataUseCase(repository)

    @Test
    fun onInvoke_callRepository_returnHomeData() = runTest(rule.testDispatcher) {
        val expected = makeHomeDataFake()
        prepareScenario(expected)

        val actual = useCase.invoke()

        actual.test {
            assertEquals(expected, this.expectMostRecentItem())
        }
    }

    @Test
    fun onInvoke_callRepository_returnsError() = runTest(rule.testDispatcher){
        coEvery { repository.fetchHomeData() } returns flow { throw NullPointerException() }

        val actual = useCase.invoke()

        actual.test {
            assertThat(awaitError(),IsInstanceOf(NullPointerException::class.java))
        }
    }

    private fun prepareScenario(
        homeData: HomeData = makeHomeDataFake()
    ) {
        coEvery { repository.fetchHomeData() } returns flowOf(homeData)
    }
}
