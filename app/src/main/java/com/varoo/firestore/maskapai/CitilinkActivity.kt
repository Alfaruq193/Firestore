package com.varoo.firestore.maskapai

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.varoo.firestore.R

class CitilinkActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var webSettings: WebSettings
    lateinit var webViewClient: WebViewClient

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citilink)

        supportActionBar?.hide()

        webView = findViewById(R.id.web_view_citilink)
        webSettings = webView.settings
        webView.webViewClient = WebViewClient()
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webView.loadUrl("https://www.citilink.co.id/")
    }
}