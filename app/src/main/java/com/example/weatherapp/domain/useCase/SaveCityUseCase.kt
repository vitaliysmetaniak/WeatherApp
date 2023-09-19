package com.example.weatherapp.domain.useCase


interface SaveCityUseCase {
    suspend operator fun invoke(city: String): Result<String>
}