package com.example.saludoapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btmHello: Button = findViewById(R.id.btmHello)
        var name =

        btmHello.setOnClickListener {
            Log.i("Test", "Botón pulsado")
            Toast.makeText(this, "Hola Usuario",Toast.LENGTH_LONG).show()

        }

    }

}