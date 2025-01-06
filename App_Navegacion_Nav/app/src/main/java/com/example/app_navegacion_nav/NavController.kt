package com.example.app_navegacion_nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import  com.example.app_navegacion_nav.Models.Routes.*

@Preview(showBackground = true)
@Composable
fun NavController(){
    val navegationController = rememberNavController()
    NavHost(navController = navegationController, startDestination = Ventana1.route) {
        composable(Ventana1.route) { Ventana1(navegationController) }
        composable(Ventana2.route) { Ventana2(navegationController) }
        composable(Ventana3.route) { Ventana3(navegationController) }

    }
}

@Composable
fun Ventana1(navCloneable: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
        )
        Button(
            onClick = {navCloneable.navigate("Ventana2")}) { }

    }
}


