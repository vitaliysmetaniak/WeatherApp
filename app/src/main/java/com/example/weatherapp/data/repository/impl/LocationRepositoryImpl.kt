package com.example.weatherapp.data.repository.impl

import com.example.weatherapp.data.preferences.LocalPreferences
import com.example.weatherapp.data.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val preference: LocalPreferences,
): LocationRepository {

    override fun getSavedCity(city: String): String? {
        val savedCity = preference.get("city") as? String
        return savedCity
    }

    override fun saveSity(city: String) {
        preference.set("city", city)
    }

}