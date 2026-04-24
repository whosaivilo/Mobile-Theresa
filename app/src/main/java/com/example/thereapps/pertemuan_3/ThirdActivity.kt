package com.example.thereapps.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.thereapps.R
import android.view.Menu
import android.view.MenuItem
import com.example.thereapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Kirim Pesan"
            subtitle = "Pertemuan 3"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        // Set onClickListener
        binding.btnKirim.setOnClickListener {

            val nomor = binding.inputNoTujuan.text

            Log.e("Klik btnSubmit", "Tombol berhasil ditekan. Isi inputNama = $nomor")


            Toast.makeText(this, "Pesan berhasil dikirim ke $nomor", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
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
            R.id.action_settings -> {
                Toast.makeText(this, "Settings Halaman 3", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
