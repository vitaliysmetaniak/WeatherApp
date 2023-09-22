package com.example.weatherapp.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCurrentWeatherBinding


class CurrentWeatherFragment: Fragment(R.layout.fragment_current_weather) {

    private lateinit var binding: FragmentCurrentWeatherBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrentWeatherBinding.bind(view)
        binding.btnCurrent.setOnClickListener {
            findNavController().navigate(R.id.forecastFragment)
        }
    }
}