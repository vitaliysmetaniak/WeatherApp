package com.example.weatherapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherapp.databinding.FragmentSearchCitySheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchCitySheetFragment: BottomSheetDialogFragment() {
    private lateinit var binding: FragmentSearchCitySheetBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearchSheet.setOnClickListener {
            Toast.makeText(requireContext(), "search city", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchCitySheetBinding.inflate(inflater, container, false)
        return binding.root
    }

}