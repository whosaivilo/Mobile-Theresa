package com.example.thereapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.thereapps.AuthActivity
import com.example.thereapps.Home.pertemuan_2.SecondActivity
import com.example.thereapps.Home.pertemuan_3.ThirdActivity
import com.example.thereapps.Home.pertemuan_4.FourthActivity
import com.example.thereapps.Home.pertemuan_5.FifthActivity
import com.example.thereapps.Home.pertemuan_7.SeventhActivity
import com.example.thereapps.R
import com.example.thereapps.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
//di fragment gasbisa pakai this, ganti jadi requireContext()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->


                    val editor = sharedPref.edit()
                    editor.clear()
//                    editor.remove("isLogin")
                    editor.apply()

//                    balikkan user ke halaman login
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    dialog.dismiss()
                    requireActivity().finish()

                }
                .setNegativeButton("Tidak", null)
                .show()
        }
        binding.btnPertemuan2.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }


        binding.btnPertemuan3.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("nama", "Bang Irgi")
            intent.putExtra("asal", "Lab 151")
            intent.putExtra("usia", "30") // Sesuaikan jika FourthActivity menerima String
            startActivity(intent)
        }


        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }
        binding.btnPertemuan7.setOnClickListener{
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }
    }
}

