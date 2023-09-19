package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.CurrentNetModel
import com.example.weatherapp.data.net.model.ForecastNetModel
import com.example.weatherapp.data.net.model.LocationNetModel
import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel

data class WeatherRepoModel(
    val current: CurrentRepoModel?=null,
    val forecast: ForecastRepoModel?=null,
    val location: LocationRepoModel?=null
) : BaseRepoModel()

fun WeatherForecastNetModel.toRepoModel() = WeatherRepoModel(
    current?.toRepoModel()?: CurrentRepoModel(),
    forecast?.toRepoModel()?: ForecastRepoModel(),
    location?.toRepoModel()?: LocationRepoModel()
)


fun WeatherRepoModel.toNetModel() = WeatherForecastNetModel(
    current?.toNetModel()?: CurrentNetModel(),
    forecast?.toNetModel()?: ForecastNetModel(),
    location?.toNetModel()?: LocationNetModel()
)
