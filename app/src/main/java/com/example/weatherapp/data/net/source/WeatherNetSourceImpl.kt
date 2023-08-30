package com.example.weatherapp.data.net.source

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.net.service.WeatherApiService
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Singleton
@Named("WeatherNetSourceImpl")
class WeatherNetSourceImpl @Inject constructor(
    private val apiService: WeatherApiService
) : WeatherNetSource {

    override suspend fun getCurrentWeather(city: String): Result<WeatherForecastNetModel> {
        return try {
            Result.success(apiService.getCurrentWeather(city))
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getCurrentWeather(
        lon: Double,
        lat: Double
    ): Result<WeatherForecastNetModel> {
        return try {
            val request = "$lat,$lon"
            Result.success(apiService.getCurrentWeather(request))
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}

