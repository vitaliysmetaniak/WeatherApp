package com.example.weatherapp.data.repository

interface LocationRepository {

    fun getSavedCity(city: String): String?

    fun saveSity(city: String)

}