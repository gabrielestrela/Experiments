package com.star.home.impl.data.repository

import app.cash.turbine.test
import com.star.home.impl.data.datasource.HomeDataSource
import com.star.home.impl.data.model.response.HomeResponse
import com.star.home.impl.domain.mapper.HomeDataToDomainMapper
import com.star.home.impl.factory.makeHomeDataFake
import com.star.home.impl.factory.makeHomeResponseFake
import com.star.home.impl.testtools.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class HomeRepositoryTest {

    @get:Rule
    val rule = CoroutineTestRule()

    private val dataSource: HomeDataSource by lazy { mockk() }
    private val mapper: HomeDataToDomainMapper by lazy { mockk() }
    private val repository: HomeRepository = HomeRepository(dataSource, mapper)

    @Test
    fun onFetchHomeData_callsDataSource_returnMappedHomeData() = runTest(rule.testDispatcher) {
        val response = makeHomeResponseFake()
        prepareScenario(response)

        val expected = makeHomeDataFake()

        val actual = repository.fetchHomeData()

        actual.test {
            assertEquals(expected, this.expectMostRecentItem())
        }
    }

    private fun prepareScenario(
        response: HomeResponse = makeHomeResponseFake()
    ) {
        coEvery { dataSource.fetchHomeData() } returns flowOf(response)
    }
}