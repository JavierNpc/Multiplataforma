package com.example.saludoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ventana1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ventana1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonVentana1: Button = findViewById(R.id.botonvent)

        botonVentana1.setOnClickListener{
            val intentMain = Intent(this, MainActivity::class.java)

            startActivity(intentMain)
        }

        val tvGreeting:TextView = findViewById(R.id.tvGreeting)
        val name:String =
            intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvGreeting.text = "Hola $name"


    }
}