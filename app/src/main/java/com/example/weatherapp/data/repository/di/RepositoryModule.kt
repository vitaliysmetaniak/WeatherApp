package com.example.weatherapp.data.repository.di

import com.example.weatherapp.data.repository.LocationRepository
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.data.repository.impl.LocationRepositoryImpl
import com.example.weatherapp.data.repository.impl.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ) : WeatherRepository

    @Binds
    @Singleton
    abstract fun bindLocationrepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository

}