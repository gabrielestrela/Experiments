package com.star.home.impl.data.datasource

import com.star.home.impl.data.api.HomeApi
import com.star.home.impl.data.model.response.HomeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteHomeDataSource(
    private val homeApi: HomeApi
) : HomeDataSource {
    override suspend fun fetchHomeData(): Flow<HomeResponse> = flow {
        val result = homeApi.getHomeData("0.0", "0.0")
        emit(result)
    }
}
