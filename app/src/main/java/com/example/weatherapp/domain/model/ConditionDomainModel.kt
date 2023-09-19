package com.example.weatherapp.domain.model

import com.example.weatherapp.data.net.model.ConditionNetModel
import com.example.weatherapp.data.repository.model.ConditionRepoModel
import com.example.weatherapp.domain.model.base.BaseDomainModel


data class ConditionDomainModel(
    val code: String?="",
    val icon: String?="",
    val text: String?=""
) : BaseDomainModel()


fun ConditionDomainModel.toRepoModel(): ConditionRepoModel {
    return ConditionRepoModel(
        code,
        icon,
        text
    )
}

fun ConditionRepoModel.toDomainModel(): ConditionDomainModel {
    return ConditionDomainModel(
        code,
        icon,
        text
    )
}

