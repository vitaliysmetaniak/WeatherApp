package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.ConditionNetModel
import com.example.weatherapp.data.net.model.DayNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel

data class DayRepoModel(
    val avghumidity: Double? = 0.0,
    val avgtempC: Double? = 0.0,
    val avgtempF: Double? = 0.0,
    val avgvisKm: Double? = 0.0,
    val avgvisMiles: Double? = 0.0,
    val condition: ConditionRepoModel? = null,
    val dailyChanceOfRain: Int? = -1,
    val dailyChanceOfSnow: Int? = -1,
    val dailyWillItRain: Int? = -1,
    val dailyWillItSnow: Int? = -1,
    val maxtempC: Double? = 0.0,
    val maxtempF: Double? = 0.0,
    val maxwindKph: Double? = 0.0,
    val maxwindMph: Double? = 0.0,
    val mintempC: Double? = 0.0,
    val mintempF: Double? = 0.0,
    val totalprecipIn: Double? = 0.0,
    val totalprecipMm: Double? = 0.0,
    val totalsnowCm: Double? = 0.0,
    val uv: Double? = 0.0
) : BaseRepoModel()

fun DayRepoModel.toNetModel(): DayNetModel {
    return DayNetModel(
        avghumidity,
        avgtempC,
        avgtempF,
        avgvisKm,
        avgvisMiles,
        condition?.toNetModel()?: ConditionNetModel(),
        dailyChanceOfRain,
        dailyChanceOfSnow,
        dailyWillItRain,
        dailyWillItSnow,
        maxtempC,
        maxtempF,
        maxwindKph,
        maxwindMph,
        mintempC,
        mintempF,
        totalprecipIn,
        totalprecipMm,
        totalsnowCm,
        uv
    )
}

fun DayNetModel.toRepoModel(): DayRepoModel {
    return DayRepoModel(
        avghumidity,
        avgtempC,
        avgtempF,
        avgvisKm,
        avgvisMiles,
        condition?.toRepoModel()?: ConditionRepoModel(),
        dailyChanceOfRain,
        dailyChanceOfSnow,
        dailyWillItRain,
        dailyWillItSnow,
        maxtempC,
        maxtempF,
        maxwindKph,
        maxwindMph,
        mintempC,
        mintempF,
        totalprecipIn,
        totalprecipMm,
        totalsnowCm,
        uv
    )
}