import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.useCase.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.model.WeatherForecastDomainModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForecastViewModel @Inject constructor(val getCurrentWeatherUseCase: GetCurrentWeatherUseCase) : ViewModel() {

    private val _currentWeatherLiveData: MutableLiveData<WeatherForecastDomainModel?> = MutableLiveData(null)
    val currentWeatherLiveData: LiveData<WeatherForecastDomainModel?> = _currentWeatherLiveData

    private val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private val _errorLiveData: MutableLiveData<Exception?> = MutableLiveData(null)
    val errorLiveData: LiveData<Exception?> = _errorLiveData

    fun getWeather(city: String) {
        _loadingLiveData.value = true // Set loading state

        viewModelScope.launch {
            try {
                val weatherResult = getCurrentWeatherUseCase(city)
                weatherResult.fold(
                    onSuccess = { result ->
                        _currentWeatherLiveData.postValue(result)
                        _loadingLiveData.postValue(false)
                    },
                    onFailure = { error ->
                        _errorLiveData.postValue(error as Exception)
                        _loadingLiveData.postValue(false)
                    }
                )
            } catch (e: Exception) {
                _errorLiveData.postValue(e)
                _loadingLiveData.postValue(false)
            }
        }
    }
}
