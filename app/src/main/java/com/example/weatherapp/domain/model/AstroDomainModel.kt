package com.example.weatherapp.domain.model

import com.example.weatherapp.data.net.model.AstroNetModel
import com.example.weatherapp.data.repository.model.AstroRepoModel
import com.example.weatherapp.domain.model.base.BaseDomainModel


data class AstroDomainModel(
    val isMoonUp: Int?=-1,
    val isSunUp: Int?=-1,
    val moonIllumination: String?="",
    val moonPhase: String?="",
    val moonrise: String?="",
    val moonset: String?="",
    val sunrise: String?="",
    val sunset: String?=""
): BaseDomainModel()

fun AstroDomainModel.toRepoModel(): AstroRepoModel {
    return AstroRepoModel(
        isMoonUp,
        isSunUp,
        moonIllumination,
        moonPhase,
        moonrise,
        moonset,
        sunrise,
        sunset
    )
}

fun AstroRepoModel.toDomainModel(): AstroDomainModel {
    return AstroDomainModel(
        isMoonUp,
        isSunUp,
        moonIllumination,
        moonPhase,
        moonrise,
        moonset,
        sunrise,
        sunset
    )
}