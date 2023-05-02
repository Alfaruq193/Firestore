package com.varoo.firestore

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.varoo.firestore.api.ApiConfig
import com.varoo.firestore.databinding.ActivityRegisBinding
import com.varoo.firestore.helper.SharedPreference
import com.varoo.firestore.model.ResponseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var webSettings: WebSettings
    lateinit var webViewClient: WebViewClient

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)

        supportActionBar?.hide()

        webView = findViewById(R.id.web_view_regis)
        webSettings = webView.settings
        webView.webViewClient = WebViewClient()
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webView.loadUrl("https://travel-applications.herokuapp.com/")
    }


}