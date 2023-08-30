package com.example.weatherapp.domain.model

import com.example.weatherapp.data.net.model.LocationNetModel
import com.example.weatherapp.data.repository.model.LocationRepoModel

data class LocationDomainModel(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tzId: String
)


fun LocationDomainModel.toRepoModel(): LocationRepoModel {
    return LocationRepoModel(
        country,
        lat,
        localtime,
        localtimeEpoch, lon, name, region, tzId
    )
}


fun LocationRepoModel.toDomainModel(): LocationDomainModel {
    return LocationDomainModel(
        country,
        lat,
        localtime,
        localtimeEpoch, lon, name, region, tzId
    )
}