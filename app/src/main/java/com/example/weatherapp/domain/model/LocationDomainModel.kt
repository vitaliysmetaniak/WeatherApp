package com.example.weatherapp.domain.model

import com.example.weatherapp.data.net.model.LocationNetModel
import com.example.weatherapp.data.repository.model.LocationRepoModel
import com.example.weatherapp.domain.model.base.BaseDomainModel

data class LocationDomainModel(
    val country: String?="",
    val lat: Double?=0.0,
    val localtime: String?="",
    val localtimeEpoch: Int?=-1,
    val lon: Double?=0.0,
    val name: String?="",
    val region: String?="",
    val tzId: String?=""
): BaseDomainModel()


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