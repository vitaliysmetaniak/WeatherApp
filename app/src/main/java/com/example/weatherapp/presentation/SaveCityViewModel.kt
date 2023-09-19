package com.example.weatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.useCase.SaveCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveCityViewModel @Inject constructor(
    private val saveCityViewModel: SaveCityUseCase
): ViewModel() {
    private val _resultLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> get() = _resultLiveData

    private val _erorLiveData = MutableLiveData<String>()
    val erorLiveData: LiveData<String> get() = _erorLiveData

    fun  saveCity(city: String) {
        viewModelScope.launch {
            val result = saveCityViewModel(city)

            result.fold(
                onSuccess = {result ->
                    _resultLiveData.postValue(result)
                },
                onFailure = {error ->
                    _erorLiveData.postValue((error as Exception).toString())
                }
            )

        }
    }

}