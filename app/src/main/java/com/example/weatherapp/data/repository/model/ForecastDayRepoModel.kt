package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.AstroNetModel
import com.example.weatherapp.data.net.model.DayNetModel
import com.example.weatherapp.data.net.model.ForecastDayNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel

data class ForecastDayRepoModel(
    val astroRepoModel: AstroRepoModel?=null,
    val date: String?="",
    val dateEpoch: Int?=-1,
    val dayRepoModel: DayRepoModel?=null,
    val hourRepoModel: List<HourRepoModel>?= emptyList()
) : BaseRepoModel()

fun ForecastDayRepoModel.toNetModel(): ForecastDayNetModel {
    return ForecastDayNetModel(
        astroRepoModel?.toNetModel()?: AstroNetModel(),
        date,
        dateEpoch,
        dayRepoModel?.toNetModel()?: DayNetModel(),
        hourRepoModel?.map { it.toNetModel() } ?: emptyList()
    )
}

fun ForecastDayNetModel.toRepoModel(): ForecastDayRepoModel {
    return ForecastDayRepoModel(
        astroNetModel?.toRepoModel() ?: AstroRepoModel(),
        date ?: "",
        dateEpoch ?: -1,
        dayNetModel?.toRepoModel() ?: DayRepoModel(),
        hourNetModel?.map { it.toRepoModel() } ?: emptyList()
    )
}