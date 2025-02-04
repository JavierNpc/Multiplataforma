package com.example.loginmvvmjavi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.loginmvvmjavi.ui.theme.LoginMVVMJaviTheme
import com.example.loginmvvmjavi.ui.theme.login.UI.LoginScreen
import com.example.loginmvvmjavi.ui.theme.login.UI.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginMVVMJaviTheme {
                LoginScreen(loginViewModel)
            }
        }
    }
}


@Preview ( showBackground = true)
@Composable
fun Visualizacion(){

    LoginScreen(LoginViewModel())
}