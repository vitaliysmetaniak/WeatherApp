package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel
import com.example.weatherapp.domain.model.CurrentDomainModel
import com.example.weatherapp.domain.model.LocationDomainModel
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import com.example.weatherapp.domain.model.toDomainModel
import com.example.weatherapp.domain.model.toNetModel

data class WeatherRepoModel(
    val current: CurrentRepoModel,
    val location: LocationRepoModel
) : BaseRepoModel()

//
//fun WeatherForecastDomainModel.toRepoModel() = WeatherRepoModel(
//    current.toRepoModel(),
//    location.toRepoModel()
//)
//
//fun WeatherRepoModel.toDomainModel() = WeatherForecastDomainModel(
//    current.toDomainModel(),
//    location.toDomainModel()
//)


fun WeatherForecastNetModel.toRepoModel() = WeatherRepoModel(
    current.toRepoModel(),
    location.toRepoModel()
)


fun WeatherRepoModel.toNetModel() = WeatherForecastNetModel(
    current.toNetModel(),
    location.toNetModel()
)
