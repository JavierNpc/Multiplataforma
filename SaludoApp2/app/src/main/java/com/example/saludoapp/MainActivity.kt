package com.example.saludoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btmHello: Button = findViewById(R.id.btmHello)
        val etName : EditText = findViewById(R.id.etName)

        btmHello.setOnClickListener {
            
            val tvGreeating:TextView = findViewById(R.id.tvGreeting)
            val name:String = intent.extras?.getString("Extra_name").orEmpty()
            tvGreeating.text = "Hola $name"

            val intentGA = Intent(this, Ventana1::class.java)
            intentGA.putExtra("EXTRA_NAME", name)
            startActivity(intentGA)
        }



    }

}

/* Log.i("Test", "Botón pulsado")
           Toast.makeText(this, "Hola Usuario",Toast.LENGTH_LONG).show()
           val name = etName.text.toString()

           if (name.isNotEmpty()) {
               Snackbar.make(btmHello, "Hola $name!", Snackbar.LENGTH_SHORT)
                   .setAnchorView(btmHello)
                   .setAction("CLOSE") { finishAffinity() }
                   .show()
           }*/