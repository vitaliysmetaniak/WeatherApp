package com.example.weatherapp.data.repository

import com.example.weatherapp.data.repository.model.WeatherRepoModel

interface WeatherRepository{
    suspend fun getCurrentWeather(city: String): Result<WeatherRepoModel>

    suspend fun getForecastWeather(city: String, days:Int): Result<WeatherRepoModel>

}