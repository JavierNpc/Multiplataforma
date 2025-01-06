package com.example.logininstagram_javi

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LoginScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .background(Color(0xFF9F9F9F))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't hava an acconunt?",
                fontSize = 12.sp,
                color = Color(0xFFB5B5B5)
                )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Sing up",
                fontSize = 12.sp,
                color = Color(0xFF4EA8E9),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { createAccount() }
            )

        }
    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable { mutableStateOf(false) }

    if (email.isNotEmpty() && password.isNotEmpty()){ isLoginEnable = true} else {isLoginEnable = false}


    Column(modifier = modifier) {
        ImageLogo((Modifier.align(Alignment.CenterHorizontally)))
        Spacer(modifier =Modifier.size(16.dp))
        Email(email) {email = it }
        Spacer(modifier =Modifier.size(8.dp))
        Password(password){password = it}
        Spacer(modifier =Modifier.size(8.dp))
        ForgotPass((Modifier.align(Alignment.End)))
        Spacer(modifier =Modifier.size(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier =Modifier.size(16.dp))
        LoginDivisor()
        Spacer(modifier =Modifier.size(32.dp))
        LoginSocial((Modifier.align(Alignment.CenterHorizontally)))
    }

}

@Composable
fun Header(modifier: Modifier) {
    val acctivity = LocalContext.current as? Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Close App",
        modifier = modifier.clickable { acctivity?.finish() }
    )
}

// Body ---------------------------------------------------------------------------
@Composable
fun LoginSocial(modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painter =  painterResource(id = R.drawable.fb ),
            contentDescription = "LogoFB",
            modifier = Modifier.size(16.dp)

        )

        Text(
            text = "Continue as David",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier.padding(horizontal = 8.dp).
            clickable { checkSocialLogin() }
        )

    }
}

@Composable
fun LoginDivisor() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(
            Modifier
                .background(Color(0xFF9F9F9F))
                .height(1.dp)
                .weight(1f)
        )

        Text(text = "OR",
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color(0xFF9F9F9F),

        )

        HorizontalDivider(
            Modifier
                .background(Color(0xFF9F9F9F))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = {checkLogin()},
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color(0xFF4EA8E9),
            disabledContentColor = Color.White,
            disabledContainerColor = Color(0xFF78C8F9)
        )

    ) {
        Text(text = "Log In")
    }
}

@Composable
fun ForgotPass(modifier: Modifier) {
   Text(text = "Forgot password?",
       fontSize = 12.sp,
       fontWeight = FontWeight.Bold,
       color = Color(0xFF4EA8E9),
       modifier = modifier.
            clickable {  sendNewPassword()}

       )
}

@Composable
fun Password(password: String, function: (String) -> Unit) {
    var passVisivility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = {function(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFFB2B2B2),
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password ),
        trailingIcon = {
            val imagen = if (passVisivility)
                            Icons.Filled.VisibilityOff
                         else
                            Icons.Filled.Visibility

            IconButton(onClick = {passVisivility = !passVisivility}) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },
        visualTransformation =
                    if (passVisivility)
                        VisualTransformation.None
                    else
                       PasswordVisualTransformation()
    )

}

@Composable
fun Email(email: String, function: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = {function(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFFB2B2B2),
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email )
    )
}

@Composable
fun ImageLogo(modifier: Modifier) {
   Image(
       painter =  painterResource(id = R.drawable.insta ),
       contentDescription = "Logo",
       modifier = modifier
   )
}

// Body ---------------------------------------------------------------------------

// Revisar porque no estan hechas
fun checkLogin() {
    TODO("Not yet implemented")
}
fun sendNewPassword() {
    TODO("Not yet implemented")
}
fun checkSocialLogin() {
    TODO("Not yet implemented")
}
fun createAccount() {
    TODO("Not yet implemented")
}