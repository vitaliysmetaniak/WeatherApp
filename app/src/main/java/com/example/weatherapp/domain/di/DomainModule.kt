package com.example.weatherapp.domain.di

import com.example.weatherapp.domain.useCase.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.impl.GetCurrentWeatherUseCaseImpl
import com.example.weatherapp.domain.useCase.GetCityUseCase
import com.example.weatherapp.domain.impl.GetCityUseCaseImpl
import com.example.weatherapp.domain.impl.GetForecastForCityFor7DaysUseCaseImpl
import com.example.weatherapp.domain.useCase.SaveCityUseCase
import com.example.weatherapp.domain.impl.SaveCityUseCaseImpl
import com.example.weatherapp.domain.useCase.GetForecastForCityFor7DaysUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    @Singleton
    abstract fun bindGetCurrentWeatherUseCase(
        getCurrentWeatherUseCaseImpl: GetCurrentWeatherUseCaseImpl
    ): GetCurrentWeatherUseCase

    @Binds
    @Singleton
    abstract fun bindGetCityUseCase(
        getCityUseCaseImpl: GetCityUseCaseImpl
    ): GetCityUseCase

    @Binds
    @Singleton
    abstract fun bindSaveCityUseCase(
        getSaveCityUseCaseModuleImpl: SaveCityUseCaseImpl
    ): SaveCityUseCase

    @Binds
    @Singleton
    abstract fun bindForecastFor7Days(
        getForecastForCityFor7DaysUseCase: GetForecastForCityFor7DaysUseCaseImpl
    ): GetForecastForCityFor7DaysUseCase

}
