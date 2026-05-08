package com.example.thereapps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.thereapps.databinding.ActivityMainBinding
import androidx.appcompat.app.AlertDialog
import com.example.thereapps.pertemuan_2.SecondActivity
import com.example.thereapps.pertemuan_3.ThirdActivity
import com.example.thereapps.pertemuan_4.FourthActivity
import com.example.thereapps.pertemuan_5.FifthActivity
import com.example.thereapps.pertemuan_7.SeventhActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->

                    val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
//                    editor.remove("isLogin")
                    editor.apply()

//                    balikkan user ke halaman login
                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    dialog.dismiss()
                    finish()

                }
                .setNegativeButton("Tidak", null)
                .show()
        }
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
        binding.btnPertemuan7.setOnClickListener{
            startActivity(Intent(this, SeventhActivity::class.java))
        }

    }
}