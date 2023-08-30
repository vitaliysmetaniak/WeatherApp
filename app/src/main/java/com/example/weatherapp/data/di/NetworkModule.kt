package com.example.weatherapp.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.example.weatherapp.MyAplication
import com.example.weatherapp.data.net.NetworkConstants
import com.example.weatherapp.data.net.service.WeatherApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// TODO: Dependency injection
// TODO: Dependency inversion
// TODO: Hilt
// TODO: SOLID
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesWeatherApiService(
        okHttpClient: OkHttpClient
    ): WeatherApiService {


        return Retrofit.Builder().apply {
            baseUrl(NetworkConstants.BASE_URL)
            client(okHttpClient)
            // TODO: JSON serializers (GSON, MOSHI, Kotlin Serializer)
            addConverterFactory(GsonConverterFactory.create())
        }.build().create(WeatherApiService::class.java)
    }


    @Provides
    fun providesHttpClient(
        @ApplicationContext applicationContext: Context
    ): OkHttpClient {

        val myChuckerCollector = ChuckerCollector(
            context = applicationContext,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_WEEK
        )

        val myChuckerInterceptor = ChuckerInterceptor.Builder(applicationContext) // `this` is the context
            .collector(myChuckerCollector)
            .maxContentLength(250_000L)
            .alwaysReadResponseBody(true)
            .build()

        return OkHttpClient.Builder()
            .connectTimeout(10_000L, TimeUnit.MILLISECONDS)
            .readTimeout(10_000L, TimeUnit.MILLISECONDS)
            .writeTimeout(10_000L, TimeUnit.MILLISECONDS)
            .addInterceptor(myChuckerInterceptor)
            .build()
    }

}