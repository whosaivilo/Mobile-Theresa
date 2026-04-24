package com.example.thereapps.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thereapps.R
import com.example.thereapps.databinding.ActivityFifthBinding
import kotlin.jvm.java


class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = "Selamat datang di pertemuan 5!"
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Search diklik", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.sub_profile -> {
                Toast.makeText(this, "Membuka Edit Profil", Toast.LENGTH_SHORT).show()
                true
        }
            R.id.sub_theme -> {
                Toast.makeText(this, "Pilih Tema Aplikasi", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.sub_logout -> {
                Toast.makeText(this, "Sesi Berakhir", Toast.LENGTH_SHORT).show()
                finish() // Menutup activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}