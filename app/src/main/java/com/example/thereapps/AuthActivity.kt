package com.example.thereapps

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.example.thereapps.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("user_pref",MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

//        if(isLogin){
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.btnLogin.setOnClickListener {
            val username = binding.editTextText.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            //logika pengecekan username dan password
            if (username == password && username.isNotEmpty()){
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username) // Bonus: simpan nama user
                editor.apply()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silakan coba lagi")
                    .setPositiveButton("OK", null)
                    .show()

            }
        }


    }
}