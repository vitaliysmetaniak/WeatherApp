package com.example.weatherapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSaveCityBinding

class SaveCityFragment: Fragment() {

    private var _binding: FragmentSaveCityBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SaveCityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSaveCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
   }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}