package com.varoo.firestore.landing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varoo.firestore.HomeActivity
import com.varoo.firestore.LoginActivity
import com.varoo.firestore.R
import com.varoo.firestore.databinding.ActivityKulinerBinding
import com.varoo.firestore.helper.SharedPreference

class KulinerActivity : AppCompatActivity() {
    lateinit var  binding: ActivityKulinerBinding

    private lateinit var sPH: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKulinerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        sPH = SharedPreference(this)

        binding.start.setOnClickListener {
            if (sPH.getStatusLogin(false)) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

    }
}