package com.example.todo_javier.toDo_MVVM.Model

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_javier.core.navegacion.NavigationController


@Preview ( showBackground = true)
@Composable
fun Vista (){
    NavigationController()
}



@Composable
fun To_Do(
    navTarea: () -> Unit,
    navHorario: () -> Unit,
    navProgresion: () -> Unit,
    navObjetivo: () -> Unit,
    navModal: () -> Unit
    ){
    Box(Modifier.background(color = Color(0xFFD2CCA8))){
        Box(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            HeaderToDo(Modifier.align(Alignment.TopEnd), { navModal() })
            BodyToDo(Modifier.align(Alignment.BottomCenter),
                { navTarea() },
                {navHorario()},
                {navProgresion()},
                {navObjetivo()},
                {navModal()}
            )//loginVM
        }
    }

}



@Composable
fun BodyToDo(
    mod: Modifier,
    navTarea:() -> Unit,
    navHorario: () -> Unit,
    navProgresion: () -> Unit,
    navObjetivo: () -> Unit,
    navModal: () -> Unit
) {
    val separacion = 40
    val altura = 250
    val ancho = 150

     Row(modifier = mod.fillMaxWidth(),
         horizontalArrangement = Arrangement.SpaceEvenly,

     ) {
         Column(modifier = Modifier,
             verticalArrangement = Arrangement.SpaceBetween) {
             Button(shape = RoundedCornerShape(20),
                 onClick = {navTarea()},
                 colors = ButtonColors(
                     containerColor = Color(0xFF94946F),
                     disabledContainerColor = Color.Unspecified,
                     disabledContentColor = Color(0xFF5D5D28),
                     contentColor = Color.Unspecified
                 ),
                modifier = Modifier
                .height(altura.dp)
                .width(ancho.dp)
             ){
                Text(modifier = Modifier
                    .rotate(45F),
                    fontSize = 30.sp,
                    text = "TAREAS",
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
             }

             Spacer(modifier = Modifier.size(separacion.dp))

             Button(shape = RoundedCornerShape(20),
                 onClick = {navProgresion()},
                 colors = ButtonColors(
                     containerColor = Color(0xFF94946F),
                     disabledContainerColor = Color.Unspecified,
                     disabledContentColor = Color(0xFF5D5D28),
                     contentColor = Color.Unspecified
                 ),
                 modifier = Modifier
                     .height(altura.dp)
                     .width(ancho.dp)
             ){
                 Text(modifier = Modifier
                     .rotate(45F),
                     fontSize = 18.sp,
                     text = "PROGRESIÓN",
                     fontFamily = FontFamily.Cursive,
                     fontWeight = FontWeight.Bold
                 )
             }
         }
         Column(modifier = Modifier) {
             Button(shape = RoundedCornerShape(20),
                 onClick = {navHorario()},
                 colors = ButtonColors(
                     containerColor = Color(0xFF94946F),
                     disabledContainerColor = Color.Unspecified,
                     disabledContentColor = Color(0xFF5D5D28),
                     contentColor = Color.Unspecified
                 ),
                 modifier = Modifier
                     .height(altura.dp)
                     .width(ancho.dp)

             ){
                 Text(modifier = Modifier
                     .rotate(45F),
                     fontSize = 25.sp,
                     text = "HORARIO",
                     fontFamily = FontFamily.Cursive,
                     fontWeight = FontWeight.Bold
                 )
             }
             Spacer(modifier = Modifier.size(separacion.dp))
             Button(shape = RoundedCornerShape(20),
                 onClick = {navObjetivo()},
                 colors = ButtonColors(
                     containerColor = Color(0xFF94946F),
                     disabledContainerColor = Color.Unspecified,
                     disabledContentColor = Color(0xFF5D5D28),
                     contentColor = Color.Unspecified
                 ),
                 modifier = Modifier
                     .height(altura.dp)
                     .width(ancho.dp)
             ){
                 Text(modifier = Modifier
                     .rotate(45F),
                     fontSize = 20.sp,
                     text = "OBJETIVOS",
                     fontFamily = FontFamily.Cursive,
                     fontWeight = FontWeight.Bold
                 )
             }
             Spacer(modifier = Modifier.size(80.dp))
         }
     }

}

//Hey
@Composable
fun HeaderToDo(mod: Modifier, navModal: () -> Unit) {

    Column {
        Spacer(modifier = Modifier.size(30.dp))
        Row(modifier = mod
            .fillMaxWidth()
            .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Row {

                Text(text = "TO-DO",
                    modifier = mod,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
            }
            Icon(imageVector = Icons.Default.Menu,
                contentDescription = "Close APP",
                modifier = mod
                    .clickable {navModal() }
                    .size(40.dp)
            )
        }

    }
}






