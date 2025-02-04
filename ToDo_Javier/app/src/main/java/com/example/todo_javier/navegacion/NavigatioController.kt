package com.example.todo_javier.core.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.todo_javier.toDo_MVVM.Model.ModeloProgreso
import com.example.todo_javier.toDo_MVVM.Model.ModeloTareas
import com.example.todo_javier.toDo_MVVM.Model.To_Do

@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  ToDo_Nav ) {
        composable<ToDo_Nav> {
            To_Do(
                navTarea = { navController.navigate(Tareas_Nav) },
                navProgresion = { navController.navigate(Progreso_Nav) },
                navObjetivo = { navController.navigate(Objetivos_Nav) },
            )
        }
        composable<Tareas_Nav> {
            ModeloTareas( /*navHome = { navController.navigate(ToDo_Nav) }*/)
        }
        composable<Progreso_Nav> {
            ModeloProgreso( navHome = { navController.navigate(ToDo_Nav) })
        }
        composable<Objetivos_Nav> {
          ModeloTareas()
        }

    }
}