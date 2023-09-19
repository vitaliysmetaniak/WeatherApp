package com.example.weatherapp.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.presentation.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getWeather("Lviv")

        val buttonGetCity: Button = findViewById(R.id.ui_button)
        val editTextCity: EditText = findViewById(R.id.et_input_city)

        buttonGetCity.setOnClickListener {
            val city = editTextCity.text.toString()
            Toast.makeText(this, "You city: $city", Toast.LENGTH_SHORT).show()
            viewModel.getWeather(city)
        }



        viewModel.apply {
            currentWeatherLiveData.observe(this@MainActivity) { forecast ->

                Log.d("weather", forecast.toString())

                forecast?.let {
                    binding.apply {
                        tvName.text = it.location?.name
                        tvRegion.text = it.location?.region
                        tvCountry.text = it.location?.country
                        tvTzId.text = it.location?.tzId
                        tvLon.text = it.location?.lon.toString()
                        tvLat.text = it.location?.lat.toString()
                        tvLocaltime.text = it.location?.localtime
                        tvLocaltimeEpoch.text = it.location?.localtimeEpoch.toString()

                        tvCloud.text = it.current?.cloud.toString()
                        tvFeelslikeC.text = it.current?.feelslikeC.toString()
                        tvFeelslikeF.text = it.current?.feelslikeF.toString()
                        tvGustKph.text = it.current?.gustKph.toString()
                        tvGustMph.text = it.current?.gustMph.toString()
                        tvHumidity.text = it.current?.humidity.toString()
                        tvIsDay.text = it.current?.isDay.toString()
                        tvLastUpdated.text = it.current?.lastUpdated
                        tvLastUpdatedEpoch.text = it.current?.lastUpdatedEpoch.toString()
                        tvPrecipIn.text = it.current?.precipIn.toString()
                        tvPrecipMm.text = it.current?.precipMm.toString()
                        tvPressureIn.text = it.current?.pressureIn.toString()
                        tvPressureMb.text = it.current?.pressureMb.toString()
                        tvTempC.text = it.current?.tempC.toString()
                        tvTempF.text = it.current?.tempF.toString()
                        tvUv.text = it.current?.uv.toString()
                        tvVisKm.text = it.current?.visKm.toString()
                        tvVisMiles.text = it.current?.visMiles.toString()
                        tvWindDegree.text = it.current?.windDegree.toString()
                        tvWindDir.text = it.current?.windDir
                        tvWindKph.text = it.current?.windKph.toString()
                        tvWindMph.text = it.current?.windMph.toString()
                        tvCode.text = it.current?.condition?.code
                        tvIcon.text = it.current?.condition?.icon
                        tvText.text = it.current?.condition?.text

                    }
                }
            }
            errorLiveData.observe(this@MainActivity) { error ->
                error?.let {
                    Toast.makeText(this@MainActivity, "isError", Toast.LENGTH_SHORT).show()
                }
            }

            isLoadingLiveData.observe(this@MainActivity) { isLoading ->
                if (isLoading){
                    Toast.makeText(this@MainActivity, "isLoading", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@MainActivity, "finished", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

