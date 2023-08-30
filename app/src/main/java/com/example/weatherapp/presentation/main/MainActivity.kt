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

// TODO 2
// TODO: add fragment "WeatherForecastFragment"
// TODO: move all logic into WeatherForecastFragment
// TODO: add Jetpack Navigation Fragment
// TODO: ad d package "presentation/forecast" -> ForecastViewModel
// TODO: add package "presentation/forecast" -> ForecaseFragment
// TODO: add package "presentation/main" -> MainActivity
// TODO: add package "presentation/main" -> MainViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // TODO: viewbinding
    // TODO: onDestroy for viewbidnging
    private lateinit var binding: ActivityMainBinding

    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getWeather("Lviv")

        // TODO observe(this@MainActivity){ - WTF?
        //  розказати що зробив з тим аплай для кращого розуміння

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
                //тут я маю стукати до форкаста вже з презентації,
                // а в презентації зробити мапінг передавання даних з домейн
                // трошки непонятно
                // перевірити  чи правильно переписав


                forecast?.let {
                    binding.apply {
                        tvCity.text = it.location.name
                        tvTemperature.text = it.current.tempC.toString()
                        tvDescription.text = it.current.condition.text
                        tvWind.text = it.current.windDir
                    }
                }
            }
            errorLiveData.observe(this@MainActivity) { error ->
                error?.let {
                    Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
                }
            }
            // TODO: ViewFlipper
            isLoadingLiveData.observe(this@MainActivity) { isLoading ->
                if (isLoading){
                    Toast.makeText(this@MainActivity, "isLoading", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@MainActivity, "finished", Toast.LENGTH_SHORT).show()
                }
            }
        }



        /*
               with(viewModel) {
            currentWeatherLiveData.observe(this@MainActivity) { forecast ->

                Log.d("weather", forecast.toString())

                // TODO: let
                // TODO: apply
                // TODO: scope functions
                forecast?.let {

                    // TODO recode using "apply" or "with" function
                    binding.tvCity.text = it.location.name
                    binding.tvTemperature.text = it.current.tempC.toString()
                    binding.tvDescription.text = it.current.condition.text
                    binding.tvWind.text = it.current.windDir
                }
            }
            errorLiveData.observe(this@MainActivity){error->
                error?.let {
                    Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
                }
            }
        }
         */




    }
}

