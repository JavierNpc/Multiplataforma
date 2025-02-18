package com.example.ej1_navegation

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
fun Screen1(navCloneable: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
        )
        Button(onClick = {}) { }

    }
}
@Composable
fun Screen2(navCloneable: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
        )
        Button(onClick = {}) { }

    }
}
@Composable
fun Screen3(navCloneable: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
        )
        Button(onClick = {}) { }

    }
}
