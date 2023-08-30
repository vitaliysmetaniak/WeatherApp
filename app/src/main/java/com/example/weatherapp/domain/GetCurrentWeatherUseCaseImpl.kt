package com.example.weatherapp.domain

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import com.example.weatherapp.domain.model.toDomainModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCurrentWeatherUseCaseImpl @Inject constructor(
    private val weatherRepository: WeatherRepository
): GetCurrentWeatherUseCase {
    override suspend operator fun invoke(city: String): Result<WeatherForecastDomainModel> {
        return weatherRepository.getCurrentWeather(city).mapCatching {repoModel ->
            repoModel.toDomainModel()
        }
    }
}

/*

class GetCurrentWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(city: String): Result<WeatherForecastDomainModel> {
        return weatherRepository.getCurrentWeather(city).mapCatching { netModel ->
            netModel.toDomainModel()
        }
    }
}





 */