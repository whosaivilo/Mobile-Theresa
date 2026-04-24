package com.example.thereapps.pertemuan_2

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.thereapps.R
import android.view.MenuItem
import android.view.Menu
import com.example.thereapps.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Input Nama"
            subtitle = "Pertemuan 2"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        binding.btnSubmit.setOnClickListener {
            val nama = binding.inputNama.text
            Toast.makeText(this, "Halo $nama", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this, "Search di Halaman 2", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
}