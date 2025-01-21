package com.example.myscaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myscaffold.ui.theme.MyScaffoldTheme
import com.example.myscaffold.ui.theme.login.ui.ToDo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyScaffoldTheme {
                ToDo()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Visor(){
    ToDo()
}