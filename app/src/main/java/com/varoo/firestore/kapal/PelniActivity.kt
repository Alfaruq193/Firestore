package com.varoo.firestore.kapal

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.varoo.firestore.R

class PelniActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var webSettings: WebSettings
    lateinit var webViewClient: WebViewClient

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelni)

        supportActionBar?.hide()

        webView = findViewById(R.id.web_view_pelni)
        webSettings = webView.settings
        webView.webViewClient = WebViewClient()
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webView.loadUrl("https://www.pelni.co.id/")
    }
}