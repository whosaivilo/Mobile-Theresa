package com.example.thereapps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thereapps.databinding.ActivityFourthBinding
import com.example.thereapps.databinding.ActivityMainBinding
import com.example.thereapps.pertemuan_4.FourthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding:   ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set onClickListener
        binding.btnKirim.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("nama", "Bang Irgi")
            intent.putExtra("asal","Lab 151")
            intent.putExtra("usia", 30)
            startActivity(intent)
        }

    }
}