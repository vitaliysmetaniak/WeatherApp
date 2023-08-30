import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentForecastBinding

// що тут робити???
// що я хотів зробити і як думав
// я тут мав відображати інтерфейс користувача
// зввертатися до вюшки і просто відображати дані
// але я все поламав
// мала бути аналогія як а мейнвюв модел
class ForecastFragment : Fragment() {

    //TODO: binding - wtf?
    private lateinit var binding: FragmentForecastBinding
    // TODO: by  (kotlin delegate)
    private val viewModel: ForecastViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForecastBinding.inflate(inflater, container, false)
        return binding.root
    }
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGetWeather.setOnClickListener {
            val city = binding.editTextCity.text.toString()
            viewModel.getWeather(city)
        }
    }
            errorLiveData.observe(viewLifecycleOwner) { error ->
                error?.let {
                    Toast.makeText(requireContext(), "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                }
            }*/
}
