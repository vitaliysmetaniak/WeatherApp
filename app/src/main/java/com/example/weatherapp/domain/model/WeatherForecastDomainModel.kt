package com.example.weatherapp.domain.model

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.repository.model.WeatherRepoModel
import com.example.weatherapp.data.repository.model.toRepoModel

data class WeatherForecastDomainModel(
    val current: CurrentDomainModel,
    val location: LocationDomainModel
)


fun WeatherForecastDomainModel.toRepoModel() = WeatherRepoModel(
    current.toRepoModel(),
    location.toRepoModel()
)

fun WeatherRepoModel.toDomainModel() = WeatherForecastDomainModel(
    current.toDomainModel(),
    location.toDomainModel()
)


/*
fun WeatherForecastNetModel.toDomainModel(): WeatherForecastDomainModel {
    return WeatherForecastDomainModel(
        current.toDomainModel(), location.toDomainModel()
    )
}
*/