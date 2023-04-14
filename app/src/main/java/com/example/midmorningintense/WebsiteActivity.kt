package com.example.midmorningintense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebsiteActivity : AppCompatActivity() {
    lateinit var myWeb:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        myWeb = findViewById(R.id.mWeb)
        var webSettings = myWeb.settings
        webSettings.javaScriptEnabled = true
        myWeb.loadUrl( "https://www.emobilis.ac.ke")
    }
}