package com.example.weatherapp.domain.model

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.repository.model.CurrentRepoModel
import com.example.weatherapp.data.repository.model.ForecastRepoModel
import com.example.weatherapp.data.repository.model.LocationRepoModel
import com.example.weatherapp.data.repository.model.WeatherRepoModel
import com.example.weatherapp.data.repository.model.toRepoModel
import com.example.weatherapp.domain.model.base.BaseDomainModel

data class WeatherForecastDomainModel(
    val current: CurrentDomainModel?=null,
    val forecast: ForecastDomainModel?=null,
    val location: LocationDomainModel?=null
): BaseDomainModel()


fun WeatherForecastDomainModel.toRepoModel() = WeatherRepoModel(
    current?.toRepoModel()?: CurrentRepoModel(),
    forecast?.toRepoModel()?: ForecastRepoModel(),
    location?.toRepoModel()?: LocationRepoModel()
)

fun WeatherRepoModel.toDomainModel() = WeatherForecastDomainModel(
    current?.toDomainModel()?:CurrentDomainModel(),
    forecast?.toDomainModel()?: ForecastDomainModel(),
    location?.toDomainModel()?: LocationDomainModel()
)
