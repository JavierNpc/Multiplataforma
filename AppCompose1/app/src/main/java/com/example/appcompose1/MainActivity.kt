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
import androidx.constraintlayout.compose.ChainStyle
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
        val size = 70.dp
        val bEnd = createEndBarrier(boxRed, boxYellow)
        val bStart = createEndBarrier(boxRed, boxYellow)
        val btop = createEndBarrier(boxRed, boxYellow)
        val bButtom = createEndBarrier(boxRed, boxYellow)

        Box(modifier = Modifier.size(size).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(size).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(size).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(boxBlue.end)
            bottom.linkTo(parent.bottom)

        })
        Box(modifier = Modifier.size(size).background(Color.Magenta).constrainAs(boxMagenta){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        })

       createHorizontalChain(boxRed,boxYellow,boxMagenta,boxBlue, chainStyle = ChainStyle.Spread)


    }
}






