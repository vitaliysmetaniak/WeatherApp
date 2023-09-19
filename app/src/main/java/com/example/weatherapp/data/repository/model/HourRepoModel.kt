package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.AstroNetModel
import com.example.weatherapp.data.net.model.ConditionNetModel
import com.example.weatherapp.data.net.model.HourNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel

data class HourRepoModel(
    val chanceOfRain: Int?=-1,
    val chanceOfSnow: Int?=-1,
    val cloud: Int?=-1,
    val condition: ConditionRepoModel?=null,
    val dewpointC: Double?=0.0,
    val dewpointF: Double?=0.0,
    val feelslikeC: Double?=0.0,
    val feelslikeF: Double?=0.0,
    val gustKph: Double?=0.0,
    val gustMph: Double?=0.0,
    val heatindexC: Double?=0.0,
    val heatindexF: Double?=0.0,
    val humidity: Int?=-1,
    val isDay: Int?=-1,
    val precipIn: Double?=0.0,
    val precipMm: Double?=0.0,
    val pressureIn: Double?=0.0,
    val pressureMb: Double?=0.0,
    val tempC: Double?=0.0,
    val tempF: Double?=0.0,
    val time: String?="",
    val timeEpoch: Int?=-1,
    val uv: Double?=0.0,
    val visKm: Double?=0.0,
    val visMiles: Double?=0.0,
    val willItRain: Int?=-1,
    val willItSnow: Int?=-1,
    val windDegree: Int?=-1,
    val windDir: String?="",
    val windKph: Double?=0.0,
    val windMph: Double?=0.0,
    val windchillC: Double?=0.0,
    val windchillF: Double?=0.0
): BaseRepoModel()

fun HourRepoModel.toNetModel(): HourNetModel {
    return HourNetModel(
        chanceOfRain,
        chanceOfSnow,
        cloud,
        condition?.toNetModel()?: ConditionNetModel(),
        dewpointC,
        dewpointF,
        feelslikeC,
        feelslikeF,
        gustKph,
        gustMph,
        heatindexC,
        heatindexF,
        humidity,
        isDay,
        precipIn,
        precipMm,
        pressureIn,
        pressureMb,
        tempC,
        tempF,
        time,
        timeEpoch,
        uv,
        visKm,
        visMiles,
        willItRain,
        willItSnow,
        windDegree,
        windDir,
        windKph,
        windMph,
        windchillC,
        windchillF
    )
}


fun HourNetModel.toRepoModel(): HourRepoModel {
    return HourRepoModel(
        chanceOfRain,
        chanceOfSnow,
        cloud,
        condition?.toRepoModel()?: ConditionRepoModel(),
        dewpointC,
        dewpointF,
        feelslikeC,
        feelslikeF,
        gustKph,
        gustMph,
        heatindexC,
        heatindexF,
        humidity,
        isDay,
        precipIn,
        precipMm,
        pressureIn,
        pressureMb,
        tempC,
        tempF,
        time,
        timeEpoch,
        uv,
        visKm,
        visMiles,
        willItRain,
        willItSnow,
        windDegree,
        windDir,
        windKph,
        windMph,
        windchillC,
        windchillF
    )
}