package com.example.weatherapp.domain

import com.example.weatherapp.domain.model.WeatherForecastDomainModel

interface GetCurrentWeatherUseCase {
//    suspend fun getCurrentWeather(city: String): Result<WeatherForecastDomainModel>
    suspend operator fun invoke(city: String): Result<WeatherForecastDomainModel>


}



/*

i


 */




