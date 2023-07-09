package com.star.home.impl.domain.usecase

import com.star.home.impl.data.repository.HomeRepository
import com.star.home.impl.domain.model.HomeData
import kotlinx.coroutines.flow.Flow

class GetHomeDataUseCase(
  private val repository: HomeRepository
) {
    suspend operator fun invoke(): Flow<HomeData> =
        repository.fetchHomeData()
}
