package com.example.weatherapp.domain.model

import com.example.weatherapp.data.repository.model.AstroRepoModel
import com.example.weatherapp.data.repository.model.DayRepoModel
import com.example.weatherapp.data.repository.model.ForecastDayRepoModel
import com.example.weatherapp.domain.model.base.BaseDomainModel

data class ForecastDayDomainModel(
    val astroRepoModel: AstroDomainModel?=null,
    val date: String?="",
    val dateEpoch: Int?=-1,
    val dayRepoModel: DayDomainModel?=null,
    val hourRepoModel: List<HourDomainModel>?= emptyList()
): BaseDomainModel()

fun ForecastDayDomainModel.toRepoModel(): ForecastDayRepoModel {
    return ForecastDayRepoModel(
        astroRepoModel?.toRepoModel()?: AstroRepoModel(),
        date,
        dateEpoch,
        dayRepoModel?.toRepoModel()?: DayRepoModel(),
        hourRepoModel?.map { it.toRepoModel() }?: emptyList()
    )
}

fun ForecastDayRepoModel.toDomainModel(): ForecastDayDomainModel {
    return ForecastDayDomainModel(
        astroRepoModel?.toDomainModel()?: AstroDomainModel(),
        date,
        dateEpoch,
        dayRepoModel?.toDomainModel()?: DayDomainModel(),
        hourRepoModel?.map { it.toDomainModel() }?: emptyList()
    )
}