package com.star.home.impl.data.repository

import com.star.home.impl.data.datasource.HomeDataSource
import com.star.home.impl.domain.mapper.HomeDataToDomainMapper
import com.star.home.impl.domain.model.HomeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class HomeRepository(
    private val remoteDataSource: HomeDataSource,
    private val dataToDomainMapper: HomeDataToDomainMapper
) {
    suspend fun fetchHomeData(): Flow<HomeData> =
        remoteDataSource.fetchHomeData().map {
            dataToDomainMapper.mapFrom(it)
        }
}
