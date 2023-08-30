package com.example.weatherapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
// TODO 1

// TODO: MVVM
// TODO: by activityViewModel && by viewModels
// TODO: LiveData
// TODO: MutableLiveData
// TODO: viewModelScope
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    val currentWeatherLiveData: MutableLiveData<WeatherForecastDomainModel?> = MutableLiveData(null)

    val errorLiveData: MutableLiveData<Exception?> = MutableLiveData(null)
    // TODO: add loading livedata
    // if == true - ide loadingd
    // if == false - pokazyemo content
    val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getWeather(city: String) {
        viewModelScope.launch {
            isLoadingLiveData.postValue(true) // Включити перевірити і пояснити
                // а де я його потім передаю,
            // це завантаження не передається виходить є а по факту не задіюється


            val foo = getCurrentWeatherUseCase(city)
//            val foo = getCurrentWeatherUseCase()

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