package com.example.thereapps.pertemuan_3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.thereapps.R
import com.example.thereapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Set onClickListener
        binding.btnKirim.setOnClickListener {

            val nomor = binding.inputNoTujuan.text

            Log.e("Klik btnSubmit", "Tombol berhasil ditekan. Isi inputNama = $nomor")


            Toast.makeText(this, "Pesan berhasil dikirim ke $nomor", Toast.LENGTH_SHORT).show()
        }


        }
    }
