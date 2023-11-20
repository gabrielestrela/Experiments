package com.star.home.impl.data.datasource

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.star.home.impl.data.api.HomeApi
import com.star.home.impl.data.model.response.HomeResponse
import com.star.home.impl.factory.makeHomeResponseFake
import com.star.home.impl.testtools.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class HomeDataSourceTest {
    @get:Rule
    val rule = CoroutineTestRule()

    private val api: HomeApi by lazy { mockk() }
    private val dataSource: HomeDataSource = RemoteHomeDataSource(api)

    @Test
    fun onFetchHomeData_callApi_returnHomeResponse() = runTest(rule.testDispatcher) {
        val expected = makeHomeResponseFake()

        prepareScenario(expected)

        val actual = dataSource.fetchHomeData()

        actual.test {
            assertEquals(expected, this.expectMostRecentItem())
        }
    }

    private fun prepareScenario(
        response: HomeResponse = makeHomeResponseFake()
    ) {
        coEvery { api.getHomeData(any(), any(), any()) } returns response
    }

}