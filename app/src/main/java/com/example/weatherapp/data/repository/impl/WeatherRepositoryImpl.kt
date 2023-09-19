package com.example.weatherapp.data.repository.impl

import com.example.weatherapp.data.net.source.WeatherNetSource
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.data.repository.model.WeatherRepoModel
import com.example.weatherapp.data.repository.model.toRepoModel
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val netSource: WeatherNetSource
) : WeatherRepository {


    override suspend fun getCurrentWeather(city: String): Result<WeatherRepoModel> {
        return netSource.getCurrentWeather(city).mapCatching { netModel ->
            netModel.toRepoModel()
        }
    }

    override suspend fun getForecastWeather(city: String, days: Int): Result<WeatherRepoModel> {
        return netSource.getWeatherForecast(city, days).mapCatching { netModel ->
            netModel.toRepoModel()
        }
    }
}