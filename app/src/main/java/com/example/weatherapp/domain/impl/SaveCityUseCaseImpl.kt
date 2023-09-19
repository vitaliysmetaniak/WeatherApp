package com.example.weatherapp.domain.impl

import com.example.weatherapp.data.repository.LocationRepository
import com.example.weatherapp.domain.useCase.SaveCityUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SaveCityUseCaseImpl @Inject constructor(
    private val locationRepository: LocationRepository
): SaveCityUseCase {

    override suspend operator fun invoke(city: String): Result<String> {
        return try {
            locationRepository.saveSity(city)
            Result.success(city)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
