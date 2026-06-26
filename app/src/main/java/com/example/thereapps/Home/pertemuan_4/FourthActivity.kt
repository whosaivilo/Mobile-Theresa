package com.example.thereapps.Home.pertemuan_4

import android.Manifest // 1. TAMBAHAN IMPORT
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts // 2. TAMBAHAN IMPORT
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thereapps.MainActivity
import com.example.thereapps.R
import com.example.thereapps.databinding.ActivityFourthBinding
import com.example.thereapps.pertemuan_9.NinthActivity
import com.example.thereapps.utils.NotificationHelper // 3. TAMBAHAN IMPORT
import com.example.thereapps.utils.PermissionHelper // 4. TAMBAHAN IMPORT
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        val nama = intent.getStringExtra("nama")
        val asal = intent.getStringExtra("asal")
        val usia = intent.getStringExtra("usia")
        Log.e("Data Intent","Nama: $nama , Usia: $usia, Asal: $asal")

        binding.btnKembali.setOnClickListener {
            finish()
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Profil $nama"
            subtitle = "Pertemuan 4"
            setDisplayHomeAsUpEnabled(true)
        }

        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
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


        binding.btnShowNotification.setOnClickListener {
            // Menyiapkan intent ke FourthActivity lagi saat notifikasi diklik
            val intentNotif = Intent(this, NinthActivity::class.java).apply {
                putExtra("nama", nama)
                putExtra("asal", asal)
                putExtra("usia", usia)
            }

            NotificationHelper.showNotification(
                this,
                "Profil Terupdate",
                "Halo $nama, data profil kamu berhasil dimuat!",
                intentNotif
            )
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
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
                Toast.makeText(this, "Mencari profil...", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings Profil", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}