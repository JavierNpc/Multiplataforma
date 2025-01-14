package com.example.loginmvvmjavi.ui.theme.login.UI


import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun loginScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Header( mod = Modifier.align(Alignment.TopEnd))
        Body( mod = Modifier.align(Alignment.Center))
        Footer( mod = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun LoginButton(loginEnable :(Boolean)){
   Button() { }
}


@Composable
fun ForgotPassword(password : String , onPassChange: (String) -> Unit){
    Text(
        text= "Forgot Password",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold


    )
}


@Composable
fun Password(password : String , onPassChange: (String) -> Unit){
    TextField(
        value = password,
        onValueChange = {onPassChange(it)},
        modifier = Modifier.fillMaxSize(),
        placeholder = {Text (text = " Email")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

    )
}

@Composable
fun Footer(mod: Modifier) {

}

@Composable
fun Header(mod : Modifier) {
    val activity = LocalContext.current as? Activity

    Icon(imageVector = Icons.Default.Close,
        contentDescription = "logo",


    )


}

@Composable
fun Body(mod: Modifier) {
    val email by rememberSaveable { mutableStateOf("") }
    val password by rememberSaveable { mutableStateOf("") }
    val  isloginEnabled by rememberSaveable { mutableStateOf(false) }
    Column(modifier = mod) {

    }
}

@Composable
fun Email(email : String, onEmailChange : (String) -> Unit){
    TextField(
        value = email,
        onValueChange = {onEmailChange(it)},
        modifier = Modifier.fillMaxSize(),
        placeholder = {Text (text = " Email")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

    )
}
