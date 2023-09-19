package com.example.weatherapp.data.net.service

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("current.json?")
    suspend fun getCurrentWeather(
        @Query("q") value: String
    ): WeatherForecastNetModel

    @GET("forecast.json?")
    suspend fun getWeatherForecast(
        @Query("q") value: String,
        @Query("days") days: Int
    ): WeatherForecastNetModel
}