package com.star.home.impl.di

import com.star.corekotlin.koin.FeatureModule
import com.star.home.impl.data.api.HomeApi
import com.star.home.impl.data.datasource.HomeDataSource
import com.star.home.impl.data.datasource.RemoteHomeDataSource
import com.star.home.impl.data.repository.HomeRepository
import com.star.home.impl.domain.mapper.HomeDataToDomainMapper
import com.star.home.impl.domain.usecase.GetHomeDataUseCase
import com.star.home.impl.presentation.viewmodel.HomeViewModel
import com.star.network.core.services.Services
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

class HomeModule : FeatureModule() {
    override val dataModule = module {
        factory { homeApi(retrofit = get(named(Services.weatherService.koinName))) }
        factory<HomeDataSource> { RemoteHomeDataSource(homeApi = get()) }
        factory { HomeRepository(remoteDataSource = get(), dataToDomainMapper = get()) }
    }

    override val domainModule = module {
        factory { HomeDataToDomainMapper() }
        factory { GetHomeDataUseCase(repository = get()) }
    }

    override val presentationModule = module {
        viewModel {
            HomeViewModel(
                dispatcher = get(),
                getHomeData = get()
            )
        }
    }
    private fun homeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)
}
