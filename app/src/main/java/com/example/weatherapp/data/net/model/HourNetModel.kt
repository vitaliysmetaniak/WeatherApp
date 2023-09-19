package com.example.weatherapp.data.net.model

import com.example.weatherapp.data.net.model.base.BaseNetModel
import com.google.gson.annotations.SerializedName

data class HourNetModel(
    @SerializedName("chance_of_rain")
    val chanceOfRain: Int? = -1,
    @SerializedName("chance_of_snow")
    val chanceOfSnow: Int? = -1,
    @SerializedName("cloud")
    val cloud: Int? = -1,
    @SerializedName("condition")
    val condition: ConditionNetModel?=null,
    @SerializedName("dewpoint_c")
    val dewpointC: Double?=0.0,
    @SerializedName("dewpoint_f")
    val dewpointF: Double?=0.0,
    @SerializedName("feelslike_c")
    val feelslikeC: Double?=0.0,
    @SerializedName("feelslike_f")
    val feelslikeF: Double?=0.0,
    @SerializedName("gust_kph")
    val gustKph: Double?=0.0,
    @SerializedName("gust_mph")
    val gustMph: Double?=0.0,
    @SerializedName("heatindex_c")
    val heatindexC: Double?=0.0,
    @SerializedName("heatindex_f")
    val heatindexF: Double?=0.0,
    @SerializedName("humidity")
    val humidity: Int? = -1,
    @SerializedName("is_day")
    val isDay: Int? = -1,
    @SerializedName("precip_in")
    val precipIn: Double?=0.0,
    @SerializedName("precip_mm")
    val precipMm: Double?=0.0,
    @SerializedName("pressure_in")
    val pressureIn: Double?=0.0,
    @SerializedName("pressure_mb")
    val pressureMb: Double?=0.0,
    @SerializedName("temp_c")
    val tempC: Double?=0.0,
    @SerializedName("temp_f")
    val tempF: Double?=0.0,
    @SerializedName("time")
    val time: String? = "",
    @SerializedName("time_epoch")
    val timeEpoch: Int? = -1,
    @SerializedName("uv")
    val uv: Double?=0.0,
    @SerializedName("vis_km")
    val visKm: Double?=0.0,
    @SerializedName("vis_miles")
    val visMiles: Double?=0.0,
    @SerializedName("will_it_rain")
    val willItRain: Int? = -1,
    @SerializedName("will_it_snow")
    val willItSnow: Int? = -1,
    @SerializedName("wind_degree")
    val windDegree: Int? = -1,
    @SerializedName("wind_dir")
    val windDir: String? = "",
    @SerializedName("wind_kph")
    val windKph: Double?=0.0,
    @SerializedName("wind_mph")
    val windMph: Double?=0.0,
    @SerializedName("windchill_c")
    val windchillC: Double?=0.0,
    @SerializedName("windchill_f")
    val windchillF: Double?=0.0
): BaseNetModel()