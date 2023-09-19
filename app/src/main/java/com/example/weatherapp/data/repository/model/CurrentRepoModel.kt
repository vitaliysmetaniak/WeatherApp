package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.ConditionNetModel
import com.example.weatherapp.data.net.model.CurrentNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel


data class CurrentRepoModel(
    val cloud: Int? =-1,
    val condition: ConditionRepoModel?=null,
    val feelslikeC: Double?=0.0,
    val feelslikeF: Double?=0.0,
    val gustKph: Double?=0.0,
    val gustMph: Double?=0.0,
    val humidity: Int? =-1,
    val isDay: Int? =-1,
    val lastUpdated: String? = "",
    val lastUpdatedEpoch: Int? =-1,
    val precipIn: Double?=0.0,
    val precipMm: Double?=0.0,
    val pressureIn: Double?=0.0,
    val pressureMb: Double?=0.0,
    val tempC: Double?=0.0,
    val tempF: Double?=0.0,
    val uv: Double?=0.0,
    val visKm: Double?=0.0,
    val visMiles: Double?=0.0,
    val windDegree: Int? =-1,
    val windDir: String? = "",
    val windKph: Double?=0.0,
    val windMph: Double? = 0.0
): BaseRepoModel()

fun CurrentNetModel.toRepoModel(): CurrentRepoModel {
    return CurrentRepoModel(
        cloud,
        condition?.toRepoModel()?: ConditionRepoModel(),
        feelslikeC,
        feelslikeF,
        gustKph,
        gustMph,
        humidity,
        isDay,
        lastUpdated,
        lastUpdatedEpoch,
        precipIn,
        precipMm,
        pressureIn,
        pressureMb,
        tempC,
        tempF,
        uv,
        visKm,
        visMiles,
        windDegree,
        windDir,
        windKph,
        windMph
    )
}

fun CurrentRepoModel.toNetModel(): CurrentNetModel {
    return CurrentNetModel(
        cloud,
        condition?.toNetModel()?: ConditionNetModel(),
        feelslikeC,
        feelslikeF,
        gustKph,
        gustMph,
        humidity,
        isDay,
        lastUpdated,
        lastUpdatedEpoch,
        precipIn,
        precipMm,
        pressureIn,
        pressureMb,
        tempC,
        tempF,
        uv,
        visKm,
        visMiles,
        windDegree,
        windDir,
        windKph,
        windMph
    )
}





