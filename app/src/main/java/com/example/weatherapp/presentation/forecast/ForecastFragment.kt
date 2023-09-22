import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentForecastWeatherBinding

class ForecastFragment : Fragment() {

    private lateinit var binding: FragmentForecastWeatherBinding

    private val viewModel: ForecastViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForecastWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }
}
