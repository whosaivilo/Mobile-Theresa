package com.example.thereapps.Home.pertemuan_13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thereapps.databinding.ActivityThirteenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class ThirteenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirteenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirteenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Hidupin Tombol Back di Toolbar
        binding.toolbarThirteenth.setNavigationOnClickListener {
            finish() // Langsung balik ke halaman sebelumnya
        }

        // 2. Pasang Adapter ke ViewPager2
        val adapter = ThirteenthTabsAdapter(this)
        binding.viewPagerThirteenth.adapter = adapter

        // 3. Tempel Tab Layout dengan ViewPager2 (Biar teks tab-nya muncul)
        TabLayoutMediator(binding.tabLayoutThirteenth, binding.viewPagerThirteenth) { tab, position ->
            tab.text = when (position) {
                0 -> "Capture"
                1 -> "Scan"
                2 -> "QR Code"
                else -> ""
            }
        }.attach()
    }
}