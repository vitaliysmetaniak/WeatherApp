package com.example.weatherapp.data.repository.impl

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.net.source.WeatherNetSource
import com.example.weatherapp.data.preferences.LocalPreferences
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.data.repository.model.WeatherRepoModel
import com.example.weatherapp.data.repository.model.toRepoModel
import com.example.weatherapp.domain.model.toDomainModel
import javax.inject.Inject

// TODO: розібратися з репозиторієм - що це таке
// TODO: DI constructor injection
// TODO: DI property injection -> get(key:String):Any?
class WeatherRepositoryImpl @Inject constructor(
    private val netSource: WeatherNetSource,
    private val preference: LocalPreferences
) : WeatherRepository {

    override suspend fun getCurrentWeather(city: String): Result<WeatherRepoModel> {
        return netSource.getCurrentWeather(city).mapCatching { netModel ->
            netModel.toRepoModel()
        }
    }

    // TODO: save curent location (city) !!!!!!!!!!
    override fun get(city: String): String? {
        val savedCity = preference.get("city") as? String
        return savedCity
    }

    // TODO: Verify
    override fun saveCity(city: String) {
        preference.set("city", city)
    }

    companion object{
        // TODO: add const for preferenced key
    }

}