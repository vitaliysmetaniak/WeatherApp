package com.example.weatherapp.data.preferences

interface LocalPreferences {
    fun get(key: String): Any?
    fun set(key: String, value: Any)
}