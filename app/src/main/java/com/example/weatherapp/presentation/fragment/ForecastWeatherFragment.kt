package com.example.weatherapp.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentForecastWeatherBinding

class ForecastWeatherFragment: Fragment(R.layout.fragment_forecast_weather) {

    private lateinit var binding: FragmentForecastWeatherBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastWeatherBinding.bind(view)

        with(binding){
            tvForecast.text="Forecast Fragment"
            btnForecast.setOnClickListener {
                findNavController().navigate(R.id.searchFragment)
            }
        }

    }

}