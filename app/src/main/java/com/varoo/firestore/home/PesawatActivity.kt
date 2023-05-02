package com.varoo.firestore.home

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import com.varoo.firestore.R
import com.varoo.firestore.maskapai.*

class PesawatActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesawat)

        supportActionBar?.hide()

        val pesawatLion = findViewById<RelativeLayout>(R.id.btn_pesawatlion)
        pesawatLion.setOnClickListener{
            startActivity(Intent(this,LionActivity::class.java))
        }

        val pesawatGaruda = findViewById<RelativeLayout>(R.id.btn_pesawatgaruda)
        pesawatGaruda.setOnClickListener{
            startActivity(Intent(this,GarudaActivity::class.java))
        }

        val pesawatSwj = findViewById<RelativeLayout>(R.id.btn_pesawatsriwijaya)
        pesawatSwj.setOnClickListener{
            startActivity(Intent(this,SriwijayaActivity::class.java))
        }

        val pesawatBtk = findViewById<RelativeLayout>(R.id.btn_pesawatbatik)
        pesawatBtk.setOnClickListener{
            startActivity(Intent(this,BatikActivity::class.java))
        }

        val pswAir = findViewById<RelativeLayout>(R.id.btn_pesawatairasia)
        pswAir.setOnClickListener{
            startActivity(Intent(this,AirAsiaActivity::class.java))
        }

        val pswCtlnk = findViewById<RelativeLayout>(R.id.btn_pesawatcitilink)
        pswCtlnk.setOnClickListener{
            startActivity(Intent(this,CitilinkActivity::class.java))
        }

    }
}