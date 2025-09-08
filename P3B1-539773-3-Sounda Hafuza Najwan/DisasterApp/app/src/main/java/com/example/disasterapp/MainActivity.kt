package com.example.listof

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listof.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // set binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // gunakan binding root
        setContentView(binding.root)

        // gunakan dumy data
        var dumy = generateDumy()

        val adapterDisaster = DisasterAdapter(dumy) {
                disaster ->
            Toast.makeText(this@MainActivity, "Lu pengen ke ${disaster.location} kah, gass", Toast.LENGTH_SHORT).show()
        }

        // jika binding sudah terisi
        with(binding) {
            // isi adapter ke view
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager= GridLayoutManager(this@MainActivity,2)
            }
        }
    }

    fun generateDumy(): List<Disaster> {
        return listOf(
            Disaster(name = "Tsunami", type = "Air"),
            Disaster(name = "Gempa", type = "Tanah"),
            Disaster(name = "Banjir", type = "Air"),
            Disaster(name = "Kebakaran", type = "Api"),
            Disaster(name = "Angin Topan", type = "Angin"),
            Disaster(name = "Badai", type = "Angin")
        )
    }
}