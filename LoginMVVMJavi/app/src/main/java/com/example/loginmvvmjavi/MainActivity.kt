package com.example.loginmvvmjavi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginmvvm.login.ui.LoginScreen
import com.example.loginmvvmjavi.ui.theme.LoginMVVMJaviTheme
import com.example.loginmvvmjavi.ui.theme.login.UI.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginMVVMJaviTheme {
                LoginScreen( LoginViewModel())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Visualizacion(){
    LoginScreen( LoginViewModel())
}