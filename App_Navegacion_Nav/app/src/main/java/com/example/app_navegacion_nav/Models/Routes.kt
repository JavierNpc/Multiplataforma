package com.example.app_navegacion_nav.Models

sealed class Routes(val route:String) {
    object Ventana1:Routes("Ventana1")
    object Ventana2:Routes("Ventana2")
    object Ventana3:Routes("Ventana3")

}