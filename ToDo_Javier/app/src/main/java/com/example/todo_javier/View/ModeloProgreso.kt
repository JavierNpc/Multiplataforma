package com.example.todo_javier.toDo_MVVM.Model

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.todo_javier.R
import com.example.todo_javier.toDo_MVVM.ViewModel.TareasViewModel


@Preview( showBackground = true)
@Composable
fun Vistarprogreso (){
    ModeloProgreso()
}



@Composable
fun ModeloProgreso(/* navHome: () -> Unit,*/){

        val buttonsColor = Color(0xFF9D8444)

        Scaffold(
            topBar = { HeaderProgreso(buttonsColor) },
            content = { padding ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(padding)
                ) {
                    BodyProgreso( Modifier.align(Alignment.Center), buttonsColor)
                }
            },
            bottomBar = { MenuProgreso() }
        )
    }



@Composable
fun BodyProgreso(mod: Modifier, buttonsColor: Color) {
    var slidervalueAltura by remember { mutableStateOf(0f) }
    var slidervaluePeso by remember { mutableStateOf(0f) }
    var text by remember { mutableStateOf("") }
    var isTextFieldVisible by remember { mutableStateOf(false) }

    Column(modifier = mod
        .fillMaxWidth()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .background( Color(0xFF9B977A), shape = RoundedCornerShape(10))
            .border(1.dp ,Color.Black, shape = RoundedCornerShape(10) )
            .width(270.dp)
            .height(560.dp)


        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column (modifier = Modifier
                    .padding(20.dp)
                ){
                    Row(modifier = Modifier) {
                        Text(
                            text = "Altura  :",
                            fontSize = 20.sp,
                        )
                        Spacer(Modifier.size(10.dp))
                        Text(
                            text = slidervalueAltura.toInt().toString(),
                            fontSize = 20.sp,
                        )
                    }
                    Slider(
                        value = slidervalueAltura,
                        onValueChange = { newValue ->
                            slidervalueAltura = newValue
                        },
                        colors = SliderColors(
                            thumbColor = buttonsColor,
                            activeTrackColor = buttonsColor,
                            activeTickColor = Color.Unspecified,
                            inactiveTrackColor = Color.White,
                            inactiveTickColor = Color.Unspecified,
                            disabledThumbColor = Color.Unspecified,
                            disabledActiveTrackColor = Color.Unspecified,
                            disabledActiveTickColor = Color.Unspecified,
                            disabledInactiveTrackColor = Color.Unspecified,
                            disabledInactiveTickColor = Color.Unspecified,
                        ),
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
                            text = slidervaluePeso.toInt().toString(),
                            fontSize = 20.sp,
                        )
                    }
                    Slider(
                        value = slidervaluePeso,
                        onValueChange = { newValue ->
                            slidervaluePeso = newValue
                        },
                        colors = SliderColors(
                            thumbColor = buttonsColor,
                            activeTrackColor =buttonsColor,
                            activeTickColor = Color.Unspecified,
                            inactiveTrackColor = Color.White,
                            inactiveTickColor = Color.Unspecified,
                            disabledThumbColor = Color.Unspecified,
                            disabledActiveTrackColor = Color.Unspecified,
                            disabledActiveTickColor = Color.Unspecified,
                            disabledInactiveTrackColor = Color.Unspecified,
                            disabledInactiveTickColor = Color.Unspecified,
                        ),
                        valueRange = 0f..100f,
                        steps = 100, // Opcional: define el número de pasos entre 0 y 100
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column (modifier = Modifier.padding(20.dp)){
                    Text(modifier = Modifier.offset(0.dp, (-10).dp),
                        text = "Cintura",
                        fontSize = 20.sp,

                    )
                    TextField( modifier = Modifier.fillMaxWidth(),
                        value = text,
                        onValueChange = { newText ->
                            text = newText
                        },
                        enabled = isTextFieldVisible,
                        label = { Text("Ingresa tu cintura") },

                    )
                }
                Column (modifier = Modifier.padding(20.dp)){
                    Switch(
                        checked = isTextFieldVisible,
                        onCheckedChange = { isChecked ->
                            isTextFieldVisible = isChecked
                        },
                        colors = SwitchColors(
                            checkedThumbColor =  Color.White,
                            checkedTrackColor = buttonsColor,
                            checkedBorderColor =  buttonsColor,
                            checkedIconColor = DefaultTintColor,
                            uncheckedThumbColor =buttonsColor,
                            uncheckedTrackColor =  Color.White,
                            uncheckedBorderColor = buttonsColor,
                            uncheckedIconColor = DefaultTintColor,
                            disabledCheckedThumbColor =  DefaultTintColor,
                            disabledCheckedTrackColor =  DefaultTintColor,
                            disabledCheckedBorderColor = DefaultTintColor,
                            disabledCheckedIconColor = DefaultTintColor,
                            disabledUncheckedThumbColor = DefaultTintColor,
                            disabledUncheckedTrackColor = DefaultTintColor,
                            disabledUncheckedBorderColor = DefaultTintColor,
                            disabledUncheckedIconColor = DefaultTintColor,
                        )
                    )
                }

            }
        }
        Spacer(Modifier.size(16.dp))

        Button(modifier = Modifier.size(80.dp,60.dp),
            onClick = {/*function()*/},
            content = {
                Icon(imageVector =ImageVector.vectorResource(R.drawable.dots),
                    contentDescription = "Close APP",
                    modifier = Modifier.size(40.dp)
                )
            },
            colors = ButtonColors(
                containerColor = buttonsColor,
                contentColor = Color.White,
                disabledContainerColor = Color.Unspecified,
                disabledContentColor = Color.Unspecified,
            ),
        )
    }


}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderProgreso(buttonsColor: Color) {
    TopAppBar(
        title = {
            Text("PROGRESO", fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(.95f)
            )
        },
        colors = TopAppBarColors(
            containerColor = buttonsColor,
            scrolledContainerColor = buttonsColor,
            navigationIconContentColor = buttonsColor,
            titleContentColor = Color.White,
            actionIconContentColor = buttonsColor
        ),
    )

}

@Composable
fun MenuProgreso() {
    BottomAppBar(
        modifier = Modifier.height(70.dp),
        containerColor = Color(0xFF9D8444),
        contentPadding = PaddingValues(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Inicio",
                modifier = Modifier
                    .clickable {}
                    .size(40.dp)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.progresion),
                contentDescription = "Progreso",
                modifier = Modifier
                    .clickable {}
                    .size(40.dp)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.tareas),
                contentDescription = "Tareas",
                modifier = Modifier
                    .clickable {}
                    .size(40.dp)
            )
        }
    }
}



