package com.example.weatherapp.domain.useCase

import com.example.weatherapp.domain.model.WeatherForecastDomainModel

interface GetForecastForCityFor7DaysUseCase {
    suspend operator fun invoke(city: String): Result<WeatherForecastDomainModel>
}