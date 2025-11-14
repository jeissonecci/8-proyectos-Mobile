package com.example.mobile_fintrack_fin

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Configuración moderna: edge-to-edge
        setContentView(R.layout.activity_main)

        // Aplica paddings para barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar y cargar el WebView
        val webView: WebView = findViewById(R.id.webview)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true // Si tu HTML usa JS
        webSettings.domStorageEnabled = true // Necesario para localStorage, si lo usas
        webSettings.allowFileAccess = true // Permitir acceso a archivos del sistema de archivos
        webSettings.allowFileAccessFromFileURLs = true // Permitir acceso a archivos desde URLs de archivo
        webView.loadUrl("file:///android_asset/index.html") // tu archivo local
    }
}
