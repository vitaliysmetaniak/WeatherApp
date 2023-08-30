package com.example.weatherapp.data.net.model


import com.google.gson.annotations.SerializedName

data class WeatherForecastNetModel(
    @SerializedName("current")
    val current: CurrentNetModel,
    @SerializedName("location")
    val location: LocationNetModel
)