package com.example.thereapps.Home.pertemuan_13

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.there_help.Home.pertemuan_13.TabCaptureFragment
import com.example.there_help.Home.pertemuan_13.TabQrcodeFragment
import com.example.there_help.Home.pertemuan_13.TabScanFragment

class ThirteenthTabsAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    // Sesuai instruksi modul: set getitemCount = 3
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCaptureFragment()
            1 -> TabScanFragment()
            2 -> TabQrcodeFragment()
            else -> TabCaptureFragment()
        }
    }
}