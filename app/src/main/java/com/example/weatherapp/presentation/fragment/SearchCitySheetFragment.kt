package com.example.weatherapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.weatherapp.databinding.FragmentSearchCitySheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchCitySheetFragment: BottomSheetDialogFragment() {
    private lateinit var binding: FragmentSearchCitySheetBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnSearchSheet.setOnClickListener {
                val result = "result"
                Toast.makeText(requireContext(), "search city", Toast.LENGTH_SHORT).show()
                parentFragmentManager.setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            }
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