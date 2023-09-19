package com.example.weatherapp.data.net.source

import com.example.weatherapp.data.net.model.WeatherForecastNetModel

interface WeatherNetSource {
       suspend fun getCurrentWeather(city: String): Result<WeatherForecastNetModel>
       suspend fun getCurrentWeather( lon: Double, lat: Double): Result<WeatherForecastNetModel>
       suspend fun getWeatherForecast( city: String, days: Int): Result<WeatherForecastNetModel>


}