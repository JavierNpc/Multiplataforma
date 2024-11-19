package com.example.appcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.appcompose1.ui.theme.AppCompose1Theme







class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCompose1Theme {
                Ejemplo()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejemplo(){

    ConstraintLayout(modifier = Modifier.fillMaxSize()){
        val (boxRed, boxBlue, boxYellow, boxMagenta)= createRefs()

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue){})
        Box(modifier = Modifier.size(125.dp).background(Color.Yellow).constrainAs(boxYellow){})
        Box(modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(boxMagenta){})
    }
}






