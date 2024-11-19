package com.example.navigationapp.Models

sealed class Routes(val route:String) {
    object Pantalla1:Routes("Screen1")
    object Pantalla2:Routes("Screen2")
    object Pantalla3:Routes("screen3")
    object Pantalla4:Routes("Screen4/{name}") {
        fun createRoute(name:String) = "Screen4/$name"
    }
    object Pantalla5:Routes("Screen5?name={name}") {
        fun createRoute(name:String) = "Screen5?name=$name"
    }
}