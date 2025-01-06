package com.example.ej1_navegation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ej1_navegation.Models.Routes.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text(modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
                text = "hola")
        }
    }
}

@Preview
@Composable
fun Contenido(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Pantalla1.route) {
        composable(Pantalla1.route) { Screen1(navigationController) }
        composable(Pantalla2.route) { Screen2(navigationController) }
        composable(Pantalla3.route) { Screen3(navigationController) }

    }

}






