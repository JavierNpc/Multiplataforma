package com.example.loginmvvmjavi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.loginmvvmjavi.ui.theme.LoginMVVMJaviTheme
import com.example.loginmvvmjavi.ui.theme.login.UI.LoginScreen
import com.example.loginmvvmjavi.ui.theme.login.UI.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginMVVMJaviTheme {
                LoginScreen(LoginViewModel())
            }
        }
    }
}

