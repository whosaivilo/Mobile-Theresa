package com.example.thereapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.example.thereapps.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, AuthActivity::class.java)
        enableEdgeToEdge()

        lifecycleScope.launch {
            delay(2000) //simulasi pengambilan data selama 2 detik`

//            cek login
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            val targetActivity = if (isLogin) {
                MainActivity::class.java
            } else {
                AuthActivity::class.java
            }


            startActivity(intent)
            finish()

        }
    }
}