package lab6.multithreading.lab6_multithreading_task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lab6.multithreading.lab6_multithreading_task3.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val newURL = URL("https://www.aziko.ru/images/NRc0e18c39b2399be3a56b8c64240db6da.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = MainViewModel()
        val bitmap = viewModel.downloadImage(newURL)
        bitmap.observe(this) { value ->
            if (value != null) {
                binding.imageView.setImageBitmap(value)
            }
        }
    }
}