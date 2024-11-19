package com.example.examen_multi_javierm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultado : AppCompatActivity() {
    private lateinit var nombre: TextView
    private lateinit var poder: TextView
    private lateinit var raza: ImageView
    private lateinit var volver: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciar()
        listeners()

        val nombrePersonaje = (intent.extras?.getString("nombre").orEmpty())
        val poderPersonaje = (intent.extras?.getString("poder").orEmpty())
        nombre.text  = nombrePersonaje
        poder.text = poderPersonaje

    }

    private fun listeners() {
        volver.setOnClickListener {
            var intento = Intent(this, Ventana1::class.java)
            startActivity(intento)
        }


    }

    private fun iniciar() {
        nombre = findViewById(R.id.NombrePer)
        raza = findViewById(R.id.Raza)
        poder = findViewById(R.id.Poder)
        volver = findViewById(R.id.volver)

    }

    private fun darValores() {

    }
}

//    val nombrePersonaje = Integer.parseInt(intent.extras?.getString("nombre").orEmpty()).toString()
//    val poderPersonaje = Integer.parseInt(intent.extras?.getString("poder").orEmpty()).toString()
//
//    nombre.text = nombrePersonaje
//    poder.text = poderPersonaje
//}