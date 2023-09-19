package com.example.weatherapp.data.net.model


import com.example.weatherapp.data.net.model.base.BaseNetModel
import com.google.gson.annotations.SerializedName

data class WeatherForecastNetModel(
    @SerializedName("current")
    val current: CurrentNetModel?=null,
    @SerializedName("forecast")
    val forecast: ForecastNetModel?=null,
    @SerializedName("location")
    val location: LocationNetModel?=null,
    ): BaseNetModel()