package com.example.weatherapp.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSearchCityBinding

class SearchCityFragment : Fragment(R.layout.fragment_search_city) {


    private lateinit var binding: FragmentSearchCityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") { reqestKey, bundle ->
            val result = bundle.getString("bundleKey")
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchCityBinding.bind(view)



        with(binding) {
            btnSearch.setOnClickListener {
                findNavController().navigate(
                    R.id.currentFragment, bundleOf(
                        "foo" to "bar"
                    )
                )
            }
            btnSearchCity.setOnClickListener {
                SearchCitySheetFragment().show(requireActivity().supportFragmentManager, "tag")
            }
        }


    }
}