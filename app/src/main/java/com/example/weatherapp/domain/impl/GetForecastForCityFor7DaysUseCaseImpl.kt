package com.example.weatherapp.domain.impl

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.useCase.GetForecastForCityFor7DaysUseCase
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import com.example.weatherapp.domain.model.toDomainModel
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetForecastForCityFor7DaysUseCaseImpl @Inject constructor(
    private val weatherRepository: WeatherRepository
) : GetForecastForCityFor7DaysUseCase {
    override suspend fun invoke(city: String): Result<WeatherForecastDomainModel> {
        return try {
            weatherRepository.getForecastWeather(city, DAYS).mapCatching {
                repoModel -> repoModel.toDomainModel()
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    companion object {
        const val DAYS = 7
    }
}