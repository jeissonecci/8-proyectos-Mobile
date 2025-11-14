package com.example.mobile_fintrack_fin

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login) // Usa TU nuevo layout

        // Aplica padding según barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa y configura el WebView
        val webView: WebView = findViewById(R.id.webview)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true // Permite JavaScript
        webSettings.domStorageEnabled = true // Permite localStorage y otras APIs
        webSettings.allowFileAccess = true
        webSettings.allowFileAccessFromFileURLs = true

        // Para que los enlaces se abran dentro del WebView
        webView.webViewClient = WebViewClient()

        // Carga tu archivo login.html
        webView.loadUrl("file:///android_asset/login.html")
    }
}
