package com.example.weatherapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.useCase.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    val currentWeatherLiveData: MutableLiveData<WeatherForecastDomainModel?> = MutableLiveData(null)

    val errorLiveData: MutableLiveData<Exception?> = MutableLiveData(null)

    val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getWeather(city: String) {
        viewModelScope.launch {
            isLoadingLiveData.postValue(true) // Включити перевірити і пояснити
              val foo = getCurrentWeatherUseCase(city)

            foo.fold(
                onSuccess = { result ->
                    isLoadingLiveData.postValue(false) // Вимкнути
                    currentWeatherLiveData.postValue(result)
                },
                onFailure = { error ->
                    isLoadingLiveData.postValue(false) // Вимкнути
                    errorLiveData.postValue(error as Exception)
                }
            )

        }
    }

}