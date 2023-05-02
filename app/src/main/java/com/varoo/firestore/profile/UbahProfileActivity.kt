package com.varoo.firestore.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varoo.firestore.R

class UbahProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_profile)
        supportActionBar?.hide()
    }
}