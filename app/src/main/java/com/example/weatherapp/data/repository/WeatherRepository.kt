package com.example.weatherapp.data.repository

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.repository.model.WeatherRepoModel

// TODO: розібратися з репозиторієм - що це таке
// TODO: DI constructor injection
// TODO: DI property injection
interface WeatherRepository{
    suspend fun getCurrentWeather(city: String): Result<WeatherRepoModel>
    abstract fun get(s: String): String?

    // TODO: Verify
    abstract fun saveCity(city: String)
}