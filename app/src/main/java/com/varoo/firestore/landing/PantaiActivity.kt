package com.varoo.firestore.landing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varoo.firestore.HomeActivity
import com.varoo.firestore.LoginActivity
import com.varoo.firestore.R
import com.varoo.firestore.databinding.ActivityPantaiBinding
import com.varoo.firestore.helper.SharedPreference

class PantaiActivity : AppCompatActivity() {
    lateinit var binding: ActivityPantaiBinding
    private lateinit var sPH: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantaiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        sPH = SharedPreference(this)

        binding.skip2.setOnClickListener {
            if (sPH.getStatusLogin(false)) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }


        }
        binding.next2.setOnClickListener {
            val i = Intent(this,KulinerActivity::class.java)
            startActivity(i)
        }
    }

}