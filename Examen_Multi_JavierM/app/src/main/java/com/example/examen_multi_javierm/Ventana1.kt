package com.example.examen_multi_javierm

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider
import com.google.android.material.textfield.TextInputEditText

class Ventana1 : AppCompatActivity() {
    var personaje1_escogido : Boolean = false


    private lateinit var botonCrear : Button
    private lateinit var ValorPoder : TextView
    private lateinit var per1 : CardView
    private lateinit var per2 : CardView
    private lateinit var per3 : CardView
    private lateinit var rsPower : RangeSlider
    private lateinit var nombre : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciar()
        listeners()

    }

    private fun iniciar(){
        botonCrear = findViewById(R.id.BotonCrear)
        ValorPoder = findViewById(R.id.ValorPoder)
        per1 = findViewById(R.id.per1)
        per2 = findViewById(R.id.per2)
        per3 = findViewById(R.id.per3)
        rsPower = findViewById(R.id.rsPower)
        nombre = findViewById(R.id.Nombre)
    }

    private  fun  listeners(){
        botonCrear.setOnClickListener{
            var init = Intent(this, Resultado::class.java)
            init.putExtra("nombre", nombre.text.toString())
            init.putExtra("poder", ValorPoder.text.toString())

            startActivity(init)


        }
        per1.setOnClickListener {
            personaje1_escogido=true
        }
        per2.setOnClickListener {
            personaje1_escogido=true
        }
        per3.setOnClickListener {
            personaje1_escogido=true
        }
        rsPower.addOnChangeListener { _, value, _ ->
            //tvHeight.text = value.toString()
            ValorPoder.text = DecimalFormat("#.##").format(value)
        }










    }

    @SuppressLint("ResourceAsColor")
    private fun setColorPer() {
        if (personaje1_escogido){
            per1.setCardBackgroundColor( getColor(personaje1_escogido))
            per2.setCardBackgroundColor( getColor(!personaje1_escogido))
            per3.setCardBackgroundColor( getColor(!personaje1_escogido))

        }

    }

    private fun getColor(isComponentSelected: Boolean):Int{
        val colorReference = if (isComponentSelected) {
            R.color.verdeClaro
        } else {
            R.color.verde
        }

        return ContextCompat.getColor(this,colorReference)
    }


}