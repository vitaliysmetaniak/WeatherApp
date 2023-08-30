package com.example.weatherapp.domain.di

import com.example.weatherapp.domain.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.GetCurrentWeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GetCurrentUseCaseModule {
    @Binds
    @Singleton
    abstract fun bindGetCurrentWeatherUseCase(
        getCurrentWeatherUseCaseImpl: GetCurrentWeatherUseCaseImpl
    ): GetCurrentWeatherUseCase
}

/*


 */