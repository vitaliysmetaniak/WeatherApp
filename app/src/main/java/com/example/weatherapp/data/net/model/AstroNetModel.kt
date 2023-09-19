package com.example.weatherapp.data.net.model


import com.example.weatherapp.data.net.model.base.BaseNetModel
import com.google.gson.annotations.SerializedName

data class AstroNetModel(
    @SerializedName("is_moon_up")
    val isMoonUp: Int? = -1,
    @SerializedName("is_sun_up")
    val isSunUp: Int? = -1,
    @SerializedName("moon_illumination")
    val moonIllumination: String? = "",
    @SerializedName("moon_phase")
    val moonPhase: String? = "",
    @SerializedName("moonrise")
    val moonrise: String? = "",
    @SerializedName("moonset")
    val moonset: String? = "",
    @SerializedName("sunrise")
    val sunrise: String? = "",
    @SerializedName("sunset")
    val sunset: String? = ""
) : BaseNetModel()