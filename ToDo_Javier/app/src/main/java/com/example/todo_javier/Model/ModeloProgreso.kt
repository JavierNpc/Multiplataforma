package com.example.todo_javier.toDo_MVVM.Model

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.todo_javier.R


//@Preview( showBackground = true)
//@Composable
//fun Vistarprogreso (){
//    ModeloProgreso()
//}



@Composable
fun ModeloProgreso(
    navHome: () -> Unit,

){

    Box(Modifier.background(color = Color(0xFFD2CCA8))
        .fillMaxSize()
    ){

        Box(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            HeaderProgreso(Modifier.align(Alignment.TopCenter))
            BodyProgreso(Modifier.align(Alignment.CenterStart))
            MenuProgreso(Modifier.align(Alignment.CenterEnd))
            Progrsion_buton(Modifier.align(Alignment.BottomStart),{ navHome() })
        }
    }

}

@Composable
fun Progrsion_buton(mod: Modifier, function: () -> Unit) {
    Box(modifier = mod.padding(20.dp)
        .offset((-10).dp)){
        Button(modifier = Modifier.size(70.dp),
            onClick = {function()},
            content = {
                Icon(imageVector =ImageVector.vectorResource(R.drawable.dots),
                    contentDescription = "Close APP",
                    modifier = Modifier.size(40.dp)
                )
            }
        )
    }
}

@Composable
fun BodyProgreso(mod: Modifier) {
    val n = 6
    val filas = (0..7).map {}
    val columas = (0..n).map {"columna $it" }
    var sliderValue_altura by remember { mutableStateOf(0f) }
    var sliderValue_peso by remember { mutableStateOf(0f) }
    var text by remember { mutableStateOf("") }
    var isTextFieldVisible by remember { mutableStateOf(false) }

    Column(modifier = mod) {
        Box(modifier = Modifier
            .background( Color(0xFF9B977A))
            .width(270.dp)
            .height(560.dp)
        ){
            Column(
                modifier = Modifier.fillMaxSize()
                    .border(3.dp ,Color.Black),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column (modifier = Modifier.padding(20.dp)){
                    Row(modifier = Modifier) {
                        Text(
                            text = "Altura  :",
                            fontSize = 20.sp,
                        )
                        Spacer(Modifier.size(10.dp))
                        Text(
                            text = sliderValue_altura.toInt().toString(),
                            fontSize = 20.sp,
                        )
                    }
                    Slider(
                        value = sliderValue_altura,
                        onValueChange = { newValue ->
                            sliderValue_altura = newValue
                        },
                        valueRange = 0f..100f,
                        steps = 100, // Opcional: define el número de pasos entre 0 y 100
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column (modifier = Modifier.padding(20.dp)){
                    Row(modifier = Modifier) {
                        Text(
                            text = "Peso  :",
                            fontSize = 20.sp,
                        )
                        Spacer(Modifier.size(10.dp))
                        Text(
                            text = sliderValue_peso.toInt().toString(),
                            fontSize = 20.sp,
                        )
                    }
                    Slider(
                        value = sliderValue_peso,
                        onValueChange = { newValue ->
                            sliderValue_peso = newValue
                        },
                        valueRange = 0f..100f,
                        steps = 100, // Opcional: define el número de pasos entre 0 y 100
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column (modifier = Modifier.padding(20.dp)){
                    Text(
                        text = "Cintura",
                        fontSize = 20.sp,
                    )
                    TextField(
                        value = text,
                        onValueChange = { newText ->
                            text = newText
                        },
                        enabled = isTextFieldVisible,
                        label = { Text("Ingresa tu cintura") }, // Etiqueta opcional
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column (modifier = Modifier.padding(20.dp)){
                    Switch(
                        checked = isTextFieldVisible,
                        onCheckedChange = { isChecked ->
                            isTextFieldVisible = isChecked
                        }
                    )
                }

            }
        }
    }


}



@Composable
fun HeaderProgreso(mod: Modifier) {
   Column{
       Spacer(modifier = Modifier.size(40.dp))
       Row(modifier = mod.fillMaxWidth()) {
           Spacer(modifier = Modifier.size(60.dp))
           Text(modifier = Modifier,
               fontSize = 35.sp,

               text = "Horario")
       }
   }

}

@Composable
fun MenuProgreso(mod: Modifier) {
    Box(modifier = mod){
        Column(modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly)
        {

            Icon(imageVector = Icons.Default.Home,
                contentDescription = "Home APP",
                modifier = Modifier
                    .clickable {}
                    .size(40.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )

            Icon(imageVector = ImageVector.vectorResource(R.drawable.progresion),
                contentDescription = "Progresion APP",
                modifier = Modifier
                    .clickable {}
                    .size(40.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )

            Icon(imageVector =ImageVector.vectorResource(R.drawable.tareas),
                contentDescription = "Close APP",
                modifier = Modifier
                    .clickable {}
                    .size(40.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}



