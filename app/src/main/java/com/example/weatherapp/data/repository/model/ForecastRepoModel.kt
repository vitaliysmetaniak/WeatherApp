package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.ForecastDayNetModel
import com.example.weatherapp.data.net.model.ForecastNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel

data class ForecastRepoModel(
    val forecastDayRepoModels: List<ForecastDayRepoModel>?= emptyList()
) : BaseRepoModel()

fun ForecastRepoModel.toNetModel(): ForecastNetModel {
    return ForecastNetModel(
        forecastDayRepoModels?.map {
            it.toNetModel()
        }
    )
}

fun ForecastNetModel.toRepoModel(): ForecastRepoModel {
    return ForecastRepoModel(
        forecastDayNetModel?.map {
            it.toRepoModel()
        } ?: emptyList()
    )
}