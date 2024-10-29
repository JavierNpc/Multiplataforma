package com.example.appicm

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class AppIMC : AppCompatActivity() {
    private var isMaleSelected : Boolean = true
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHeight: TextView
    private lateinit var tvPeso : TextView
    private lateinit var tvEdad : TextView
    private lateinit var btnPesoMas : FloatingActionButton
    private lateinit var btnPesoMenos : FloatingActionButton
    private lateinit var btnEdadMas : FloatingActionButton
    private lateinit var btnEdadMenos : FloatingActionButton
    private lateinit var btnCalcular : Button


    private fun initComponents() {
        viewMale = findViewById(R.id.cardMale)
        viewFemale = findViewById(R.id.cardFemale)
        rsHeight  = findViewById(R.id.rsHeight)
        tvHeight = findViewById(R.id.tvHeight)
        tvEdad = findViewById(R.id.tvEdad)
        tvPeso = findViewById(R.id.tvPeso)
        btnEdadMas = findViewById(R.id.btnEdadMas)
        btnEdadMenos = findViewById(R.id.btnEdadMenos)
        btnPesoMas = findViewById(R.id.btnPesoMas)
        btnPesoMenos = findViewById(R.id.btnPesoMenos)
        btnCalcular = findViewById(R.id.btnCalcular)

    }


    private fun initListeners() {
        viewFemale.setOnClickListener {
            isMaleSelected=false
            setGenderColor()
        }
        viewMale.setOnClickListener {
            isMaleSelected=true
            setGenderColor();
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            //tvHeight.text = value.toString()
            tvHeight.text = DecimalFormat("#.##").format(value) + " cm"
        }

        btnEdadMas.setOnClickListener{
            tvEdad.text = DecimalFormat("##.#").format(setEdad() + 1)
        }
        btnEdadMenos.setOnClickListener{
            tvEdad.text = DecimalFormat("##.#").format(setEdad() - 1)
        }


        btnPesoMas.setOnClickListener{
            tvPeso.text = DecimalFormat("##.#").format(setPeso() + 1)
        }

        btnPesoMenos.setOnClickListener{
            tvPeso.text = DecimalFormat("##.#").format(setPeso() - 1)
        }

        btnCalcular.setOnClickListener{

        }



    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(!isMaleSelected))
    }

    private fun getBackgroundColor(isComponentSelected: Boolean):Int{
        val colorReference = if (isComponentSelected) {
            R.color.bg_comp_sel
        } else {
            R.color.bg_comp
        }

        return ContextCompat.getColor(this,colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setEdad()
        setPeso()
    }

    private fun setPeso() : Int  {
        return Integer.parseInt(tvPeso.text.toString())

    }

    private fun setEdad() : Int {
        return Integer.parseInt(tvEdad.text.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_icm)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

}