package com.example.weatherapp.data.net.model


import com.example.weatherapp.data.net.model.base.BaseNetModel
import com.google.gson.annotations.SerializedName

data class ForecastNetModel(
    @SerializedName("forecastday")
    val forecastDayNetModel: List<ForecastDayNetModel>?= emptyList()
): BaseNetModel()