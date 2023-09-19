package com.example.weatherapp.data.repository.model

import com.example.weatherapp.data.net.model.ConditionNetModel
import com.example.weatherapp.data.repository.model.base.BaseRepoModel
import com.google.gson.annotations.SerializedName

data class ConditionRepoModel(
    val code: String?="",
    val icon: String?="",
    val text: String?=""
): BaseRepoModel()

fun ConditionRepoModel.toNetModel(): ConditionNetModel{
    return ConditionNetModel(
        code,
        icon,
        text
    )
}

fun ConditionNetModel.toRepoModel(): ConditionRepoModel{
    return ConditionRepoModel(
        code,
        icon,
        text
    )
}