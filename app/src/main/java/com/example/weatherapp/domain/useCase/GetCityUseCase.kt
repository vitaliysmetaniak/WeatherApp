package com.example.weatherapp.domain.useCase


interface GetCityUseCase {
    suspend operator fun invoke(city: String): Result<String>
}
