package com.example.weatherapp.data.di

import com.example.weatherapp.data.preferences.LocalPreferences
import com.example.weatherapp.data.preferences.LocalPreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceNetModule {
    @Binds
    @Singleton
    abstract fun bindPreferenceNetModule(
        localPreferencesImpl: LocalPreferencesImpl
    ): LocalPreferences

}


/*

@Module
@InstallIn(SingletonComponent::class)
abstract class NetSourceModule {

    @Binds
    @Singleton
    abstract fun bindWeatherNetSource(
        weatherNetSourceImpl: WeatherNetSourceImpl
    ): WeatherNetSource

}

 */