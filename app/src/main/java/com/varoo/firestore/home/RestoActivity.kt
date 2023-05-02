package com.varoo.firestore.home

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.varoo.firestore.R

class RestoActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var webSettings: WebSettings
    lateinit var webViewClient: WebViewClient

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resto)

        supportActionBar?.hide()

        webView = findViewById(R.id.web_view_resto)
        webSettings = webView.settings
        webView.webViewClient = WebViewClient()
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webView.loadUrl("https://pergikuliner.com/")
    }
}