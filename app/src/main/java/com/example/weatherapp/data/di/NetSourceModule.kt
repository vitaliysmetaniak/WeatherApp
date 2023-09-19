package com.example.weatherapp.data.di

import com.example.weatherapp.data.net.source.WeatherNetSource
import com.example.weatherapp.data.net.source.impl.WeatherNetSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetSourceModule {

    @Binds
    @Singleton
    abstract fun bindWeatherNetSource(
        weatherNetSourceImpl: WeatherNetSourceImpl
    ): WeatherNetSource

}
