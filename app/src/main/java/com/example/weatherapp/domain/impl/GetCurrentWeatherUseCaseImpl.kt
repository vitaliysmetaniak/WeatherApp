package com.example.weatherapp.domain.impl

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.useCase.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import com.example.weatherapp.domain.model.toDomainModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCurrentWeatherUseCaseImpl @Inject constructor(
    private val weatherRepository: WeatherRepository
): GetCurrentWeatherUseCase {
    override suspend operator fun invoke(city: String): Result<WeatherForecastDomainModel> {
        return try {
            return weatherRepository.getCurrentWeather(city).mapCatching {repoModel ->
                repoModel.toDomainModel()
            }
        } catch (e: Exception){
            Result.failure(e)
        }


    }
}
