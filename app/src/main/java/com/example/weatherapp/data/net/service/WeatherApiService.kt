package com.example.weatherapp.data.net.service

import com.example.weatherapp.data.net.model.CurrentNetModel
import com.example.weatherapp.data.net.model.LocationNetModel
import com.example.weatherapp.data.net.model.WeatherForecastNetModel
import retrofit2.http.GET
import retrofit2.http.Query

// TODO: Retrofit
// TODO: Okhttp
// TODO: HTTP request method
// TODO: Retrofit @Query
// TODO: Retrofit @Path
// TODO: Retrofit @Header
interface WeatherApiService {

    // TODO: move key as a query parameter (like "q")
    // TODO: store api key as a BuildConfig field
    @GET("current.json?key=0e9b2c5ac222452a9b7110851230508")
    suspend fun getCurrentWeather(@Query("q") value: String): WeatherForecastNetModel

//    // TODO: add new endpoint VERIFY
//    //http://api.weatherapi.com/v1/future.json?key=0e9b2c5ac222452a9b7110851230508&q=Lviv
//    suspend fun getCurrentWeatherLocation(@Query("q") lon: Double, lat: Double): LocationNetModel
//
//    suspend fun getCurrentWeatherIpAdress(@Query("q") lon: Double, lat: Double): LocationNetModel
}