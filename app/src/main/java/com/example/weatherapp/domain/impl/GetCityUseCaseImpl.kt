package com.example.weatherapp.domain.impl

import com.example.weatherapp.data.repository.LocationRepository
import com.example.weatherapp.domain.useCase.GetCityUseCase
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCityUseCaseImpl @Inject constructor(
    private val locationRepository: LocationRepository
) : GetCityUseCase {
    override suspend fun invoke(city: String): Result<String> {
        return try {
            locationRepository.getSavedCity(city)
            Result.success(city)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
