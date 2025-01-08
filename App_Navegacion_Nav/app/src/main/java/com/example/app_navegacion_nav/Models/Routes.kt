package com.example.app_navegacion_nav.Models

sealed class Routes(val route:String) {
    object Ventana1:Routes("Ventana1")
    object Ventana2:Routes("Ventana2/{name}"){
        fun createRoute(name:String) = "String&name"
    }
    object Ventana3:Routes("Ventana3")

}