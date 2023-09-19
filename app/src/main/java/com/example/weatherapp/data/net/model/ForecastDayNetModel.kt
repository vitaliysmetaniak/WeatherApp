package com.example.weatherapp.data.net.model


import com.example.weatherapp.data.net.model.base.BaseNetModel
import com.google.gson.annotations.SerializedName

data class ForecastDayNetModel(
    @SerializedName("astro")
    val astroNetModel: AstroNetModel?=null,
    @SerializedName("date")
    val date: String?="",
    @SerializedName("date_epoch")
    val dateEpoch: Int?=-1,
    @SerializedName("day")
    val dayNetModel: DayNetModel?=null,
    @SerializedName("hour")
    val hourNetModel: List<HourNetModel>?= emptyList()
): BaseNetModel()