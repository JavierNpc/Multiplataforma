package com.example.todo_javier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.todo_javier.core.navegacion.NavigationController
import com.example.todo_javier.toDo_MVVM.ViewModel.TareasViewModel
import com.example.todo_javier.ui.theme.ToDo_JavierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDo_JavierTheme {
                NavigationController( TareasViewModel() )
            }
        }
    }
}

