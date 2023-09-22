package com.example.weatherapp.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSearchCityBinding

class SearchCityFragment: Fragment(R.layout.fragment_search_city) {
    private lateinit var binding: FragmentSearchCityBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchCityBinding.bind(view)
        binding.btnSearch.setOnClickListener {
            findNavController().navigate(R.id.currentFragment)
        }

        binding.btnSearchCity.setOnClickListener {
            SearchCitySheetFragment().show(requireActivity().supportFragmentManager, "tag")
        }
    }
}