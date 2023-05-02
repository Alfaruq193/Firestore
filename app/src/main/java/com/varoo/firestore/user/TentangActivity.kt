package com.varoo.firestore.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varoo.firestore.R

class TentangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)

        supportActionBar?.hide()
    }
}