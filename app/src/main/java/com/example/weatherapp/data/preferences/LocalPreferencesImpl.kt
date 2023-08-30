package com.example.weatherapp.data.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

// TODO 3


class LocalPreferencesImpl @Inject constructor(
    @ApplicationContext
    private val context: Context
) : LocalPreferences {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    override fun get(key: String): Any? {
        return sharedPreferences.all[key]
    }

    override fun set(key: String, value: Any) {
        sharedPreferences.edit().apply {
            // знайшов приклад змавпував мб щось не те розпитати
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> throw IllegalArgumentException("Unsupported value type")
            }
            apply()
        }
    }
}
