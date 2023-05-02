package com.varoo.firestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varoo.firestore.databinding.ActivityMainBinding
import com.varoo.firestore.helper.SharedPreference
import com.varoo.firestore.landing.PantaiActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

        private lateinit var sPH: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        sPH = SharedPreference(this)

        binding.skip1.setOnClickListener {
            if (sPH.getStatusLogin(false)) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }


        }
        binding.next1.setOnClickListener {
            val i = Intent(this, PantaiActivity::class.java)
            startActivity(i)
        }
    }

}