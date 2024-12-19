package com.example.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationapp.Models.Superhero.*
import com.example.navigationapp.ui.theme.NavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        NavigationAppTheme {
            SuperHeroView()
        }


//            NavigationAppTheme {
//                val navigationController = rememberNavController()
//                NavHost(navController = navigationController, startDestination = Pantalla1.route) {
//                    composable(Pantalla1.route) { Screen1(navigationController) }
//                    composable(Pantalla2.route) { Screen2(navigationController) }
//                    composable(Pantalla3.route) { Screen3(navigationController) }
//                    composable(
//                        Pantalla4.route,
//                        arguments = listOf(navArgument("name") { type = NavType.StringType })
//                    ) {
//                        Screen4(
//                            navigationController,
//                            it.arguments?.getString("name").orEmpty()
//                        )
//                    }
//                    composable(
//                       Pantalla5.route,
//                        arguments = listOf(navArgument("name") { defaultValue = "Pepe" })
//                    ) {
//                        Screen5(
//                            navigationController,
//                            it.arguments?.getString("name").orEmpty()
//                        )
//                    }
//                }
//            }
        }
    }

    private fun composable(route: Any, function: @Composable () -> Unit) {

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationAppTheme {
        SuperHeroView()
    }

}