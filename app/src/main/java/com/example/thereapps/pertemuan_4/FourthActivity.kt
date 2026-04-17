package com.example.thereapps.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thereapps.MainActivity
import com.example.thereapps.R
import com.example.thereapps.databinding.ActivityFourthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val nama = intent.getStringExtra("nama")
        val asal = intent.getStringExtra("asal")
        val usia = intent.getStringExtra("usia")
        Log.e("Data Intent","Nama: $nama , Usia: $usia, Asal: $asal")
        binding.btnKembali.setOnClickListener {
           finish()
        }
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
//                    finish() aksi apapun bisa diletakkan disini
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }
        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apa anda suka mata kuliah ini?")
                .setPositiveButton("Banget lah!") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNegativeButton("Ya kali engga") { dialog, _ ->
                    dialog.dismiss()
                    finish()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }
        Log.e("onCreate", "FourthActivity dibuat pertama kali")
    }
    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
    }
}