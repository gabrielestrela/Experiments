package com.star.home.impl.domain.mapper

import com.star.home.impl.factory.makeHomeDataFake
import com.star.home.impl.factory.makeHomeResponseFake
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HomeDataToDomainMapperTest {

    private val mapper: HomeDataToDomainMapper = HomeDataToDomainMapper()

    @Test
    fun onMapFrom_mapValuesCorrectly() {
        val response = makeHomeResponseFake()
        val expected = makeHomeDataFake()

        val actual = mapper.mapFrom(response)

        assertEquals(expected, actual)
    }
}