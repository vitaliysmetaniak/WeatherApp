package com.example.weatherapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.useCase.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import kotlinx.coroutines.launch

class MainViewModel(private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase) : ViewModel() {

    val currentWeatherLiveData: MutableLiveData<WeatherForecastDomainModel?> = MutableLiveData(null)
    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val errorLiveData: MutableLiveData<Exception?> = MutableLiveData(null)

    fun getWeather(city: String) {
        loadingLiveData.value = true // Set loading state

        viewModelScope.launch {
            try {
                val weatherResult = getCurrentWeatherUseCase(city)
                weatherResult.fold(
                    onSuccess = { result ->
                        currentWeatherLiveData.postValue(result)
                        loadingLiveData.postValue(false)
                    },
                    onFailure = { error ->
                        errorLiveData.postValue((error.cause as? Exception))
                        loadingLiveData.postValue(false)
                    }
                )
            } catch (e: Exception) {
                errorLiveData.postValue(e)
                loadingLiveData.postValue(false)
            }
        }
    }
}