package com.example.appicm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppICM : AppCompatActivity() {

    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView
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

    private fun initUI() {
        setGenderColor()
    }

    private fun initListeners() {
        cardFemale.setOnClickListener(){
           setGenderColor()
        }
        cardMale.setOnClickListener(){
            setGenderColor()
        }
    }

    private fun setGenderColor() {
        cardFemale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cardMale.setCardBackgroundColor(getBackgroundColor(!isMaleSelected))
    }

    private fun getBackgroundColor(isComponentSelected: Boolean):Int{
        val colorReference = if(isComponentSelected){
            R.color.bg_comp_sel
        }else{
            R.color.bg_comp
        }

        return colorReference
    }

    private fun initComponents() {
        cardFemale = findViewById(R.id.cardFemale)
        cardMale = findViewById(R.id.cardMale)
    }
}