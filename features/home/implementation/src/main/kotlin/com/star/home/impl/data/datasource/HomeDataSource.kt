package com.star.home.impl.data.datasource

import com.star.home.impl.data.model.response.HomeResponse
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {
    suspend fun fetchHomeData(): Flow<HomeResponse>
}
