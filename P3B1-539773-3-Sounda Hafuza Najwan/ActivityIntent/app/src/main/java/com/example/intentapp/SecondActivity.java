package com.example.intenapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intenapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result -> // Memeriksa result code
        if (result.resultCode == Activity.RESULT_OK) {
            // Mengambil data Intent
            val data = result.data

            // Mendapatkan alamat dari data Intent
            val address = data?.getStringExtra(MainActivity.EXTRA_ADDRESS)

            // Menetapkan teks di TextView
            binding.txtAddress.text = "Alamat: $address"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        var address = intent.getStringExtra(MainActivity.EXTRA_ADDRESS)

        // simulasi
        // Second -> Third (input data) -> Third kembali ke Second dengan result -> tampilkan di Second

        with(binding) {
            txtName.text = "Welcome to Second Activity, ${name}"
            txtAddress.text = "Alamat belum dilengkapi."
            btnToThirdActivity.setOnClickListener {
                val intenToInputAddress = Intent(this@SecondActivity, InputAddressActivity::class.java)
                launcher.launch(intenToInputAddress)
            }
        }
    }
}