package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.LocationNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel
import com.example.weatherapp.domain.model.LocationDomainModel

data class LocationRepoModel(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tzId: String
) : BaseRepoModel()

fun LocationRepoModel.toNetModel(): LocationNetModel {
    return LocationNetModel(
        country,
        lat,
        localtime,
        localtimeEpoch,
        lon,
        name,
        region,
        tzId
    )
}


fun LocationNetModel.toRepoModel(): LocationRepoModel {
    return LocationRepoModel(
        country,
        lat,
        localtime,
        localtimeEpoch,
        lon,
        name,
        region,
        tzId
    )
}