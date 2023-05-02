package com.varoo.firestore.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.varoo.firestore.R
import com.varoo.firestore.kapal.FeriActivity
import com.varoo.firestore.kapal.PelniActivity
import com.varoo.firestore.maskapai.LionActivity

class KapalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kapal)
        supportActionBar?.hide()

        val kapalFeri = findViewById<RelativeLayout>(R.id.btn_kapalferi)
        kapalFeri.setOnClickListener{
            startActivity(Intent(this, FeriActivity::class.java))
        }
        val kapalPelni = findViewById<RelativeLayout>(R.id.btn_kapalpelni)
        kapalPelni.setOnClickListener{
            startActivity(Intent(this, PelniActivity::class.java))
        }
    }
}