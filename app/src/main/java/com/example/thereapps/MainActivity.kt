package com.example.thereapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.thereapps.databinding.ActivityMainBinding
import com.example.thereapps.pertemuan_2.SecondActivity
import com.example.thereapps.pertemuan_3.ThirdActivity
import com.example.thereapps.pertemuan_4.FourthActivity
import com.example.thereapps.pertemuan_5.FifthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPertemuan2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


        binding.btnPertemuan3.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("nama", "Bang Irgi")
            intent.putExtra("asal", "Lab 151")
            intent.putExtra("usia", "30") // Sesuaikan jika FourthActivity menerima String
            startActivity(intent)
        }


        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(this, FifthActivity::class.java))
        }
    }
}