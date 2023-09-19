package com.example.weatherapp.data.net.model


import com.example.weatherapp.data.net.model.base.BaseNetModel
import com.google.gson.annotations.SerializedName


data class LocationNetModel(
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("lat")
    val lat: Double?=0.0,
    @SerializedName("localtime")
    val localtime: String? = "",
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int?=-1,
    @SerializedName("lon")
    val lon: Double?=0.0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("region")
    val region: String? = "",
    @SerializedName("tz_id")
    val tzId: String? = ""
): BaseNetModel()