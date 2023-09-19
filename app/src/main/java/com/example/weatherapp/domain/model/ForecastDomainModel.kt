package com.example.weatherapp.domain.model

import com.example.weatherapp.data.repository.model.ForecastRepoModel
import com.example.weatherapp.domain.model.base.BaseDomainModel

data class ForecastDomainModel(
    val forecastDayDomainModel: List<ForecastDayDomainModel>?= emptyList()
): BaseDomainModel()

fun ForecastDomainModel.toRepoModel(): ForecastRepoModel {
    return ForecastRepoModel(
        forecastDayDomainModel?.map { it.toRepoModel() }?: emptyList()
    )
}

fun ForecastRepoModel.toDomainModel(): ForecastDomainModel {
    return ForecastDomainModel(
        forecastDayRepoModels?.map { it.toDomainModel() }?: emptyList()
    )
}