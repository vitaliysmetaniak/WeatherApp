package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.AstroNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel

data class AstroRepoModel(
    val isMoonUp: Int? = -1,
    val isSunUp: Int? = -1,
    val moonIllumination: String? = "",
    val moonPhase: String? = "",
    val moonrise: String? = "",
    val moonset: String? = "",
    val sunrise: String? = "",
    val sunset: String? = ""
) : BaseRepoModel()

fun AstroRepoModel.toNetModel(): AstroNetModel {
    return AstroNetModel(
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

fun AstroNetModel.toRepoModel(): AstroRepoModel {
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