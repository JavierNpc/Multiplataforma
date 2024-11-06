package com.example.appicm

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.AutoCompleteTextView.Validator
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import kotlin.math.pow

class Ventana : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textVentana : TextView = findViewById(R.id.textoVentana)
        val resultadoVentana : TextView = findViewById(R.id.resultadoVentana)
        val btnReCalc : Button = findViewById(R.id.bntReCalc)

        val peso = Integer.parseInt(intent.extras?.getString("peso").orEmpty())
        val edad = Integer.parseInt(intent.extras?.getString("edad").orEmpty())
        val alturaString = Integer.parseInt(intent.extras?.getString("altura").orEmpty().substring(0,3)).toDouble()
        val altura : Double =  (alturaString / 100)
        val sexo = intent.extras?.getBoolean("sexo")
        val resultado : String = DecimalFormat("##.##").format(peso/ altura.pow(2.0))

        btnReCalc.setOnClickListener{

            val intentGA = Intent(this, AppIMC::class.java)
            startActivity(intentGA)
            
        }


        when(resultado){
            (0.0..18.5).toString() -> textVentana.text = "Bajo Peso"
//            (18.6..24.9) -> textVentana.text = "Peso Normal"
//            (25.0..29.9) -> textVentana.text = "Sobrepeso"
//            (30.0..34.9) -> textVentana.text = "Obesidad 1"
//            (35.0..39.9) -> textVentana.text = "Obesidad 2"
//            0.0..100.0-> textVentana.text = "Obesidad 3"

        }

        resultadoVentana.text = resultado
    }


}