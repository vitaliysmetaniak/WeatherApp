package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.ConditionNetModel
import com.example.weatherapp.data.net.model.CurrentNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel
import com.example.weatherapp.domain.model.CurrentDomainModel

data class CurrentRepoModel(
    val cloud: Int,
    val condition: ConditionNetModel,
    val feelslikeC: Double,
    val feelslikeF: Double,
    val gustKph: Double,
    val gustMph: Double,
    val humidity: Int,
    val isDay: Int,
    val lastUpdated: String,
    val lastUpdatedEpoch: Int,
    val precipIn: Double,
    val precipMm: Double,
    val pressureIn: Double,
    val pressureMb: Double,
    val tempC: Double,
    val tempF: Double,
    val uv: Double,
    val visKm: Double,
    val visMiles: Double,
    val windDegree: Int,
    val windDir: String,
    val windKph: Double,
    val windMph: Double
): BaseRepoModel()

fun CurrentNetModel.toRepoModel(): CurrentRepoModel {
    return CurrentRepoModel(
        cloud,
        condition,
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
        condition,
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





