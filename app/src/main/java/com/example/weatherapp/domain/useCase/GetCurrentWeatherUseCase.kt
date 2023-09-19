package com.example.weatherapp.domain.useCase

import com.example.weatherapp.domain.model.WeatherForecastDomainModel

interface GetCurrentWeatherUseCase {
    suspend operator fun invoke(city: String): Result<WeatherForecastDomainModel>


}



/*

i


 */




