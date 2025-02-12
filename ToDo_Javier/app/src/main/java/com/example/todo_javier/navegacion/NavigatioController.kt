package com.example.todo_javier.core.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo_javier.navegacion.Progreso_Nav
import com.example.todo_javier.navegacion.Tareas_Nav
import com.example.todo_javier.navegacion.ToDo_Nav

import com.example.todo_javier.toDo_MVVM.Model.ModeloProgreso
import com.example.todo_javier.View.ModeloTareas
import com.example.todo_javier.toDo_MVVM.Model.To_Do
import com.example.todo_javier.toDo_MVVM.ViewModel.TareasViewModel

@Composable
fun NavigationController(tareasViewModel: TareasViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  ToDo_Nav ) {
        composable<ToDo_Nav> {
            To_Do(
                navTarea = { navController.navigate(Tareas_Nav) },
                navProgreso = { navController.navigate(Progreso_Nav)}
            )
        }
        composable<Tareas_Nav> {
            ModeloTareas(tareasViewModel)
        }
        composable<Progreso_Nav> {
            ModeloProgreso( /*navHome = { navController.navigate(ToDo_Nav)}*/)
        }


    }
}