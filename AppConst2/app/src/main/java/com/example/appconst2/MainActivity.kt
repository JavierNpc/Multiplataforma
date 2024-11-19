package com.example.appconst2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.appconst2.ui.theme.AppConst2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppConst2Theme {

                Tabla()

            }
        }
    }
}

@Composable
fun Tabla() {

    Column {
        Text( modifier = Modifier.fillMaxWidth(), text = "Titulo", fontSize = 30.sp , textAlign = TextAlign.Center)
        Text( modifier = Modifier.fillMaxWidth(), text = "Subtitulo", fontSize = 20.sp , textAlign = TextAlign.Center)
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Hello svvfmms")
            Text(" Javier")
            Text(" Javier")
        }
    }


}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppConst2Theme {
        Tabla()
    }
}