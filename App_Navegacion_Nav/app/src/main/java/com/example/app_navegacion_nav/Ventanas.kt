package com.example.app_navegacion_nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun Ventana2(navCloneable: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
        )
        Button(onClick = {navCloneable.navigate("Ventana3")}) { }

    }
}

@Composable
fun Ventana3(navCloneable: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
        )
        Button(onClick = {navCloneable.navigate("Ventana1")}) { }

    }
}