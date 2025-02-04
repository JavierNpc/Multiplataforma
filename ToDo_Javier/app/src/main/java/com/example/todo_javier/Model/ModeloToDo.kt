package com.example.todo_javier.toDo_MVVM.Model

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch


@Preview ( showBackground = true)
@Composable
fun Vista (){
    NavigationController()
}



@Composable
fun To_Do(
    navTarea: () -> Unit,
    navProgresion: () -> Unit,
    navObjetivo: () -> Unit,
    ){
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    Box(Modifier.background(color = Color(0xFFD2CCA8))){
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    MyNavigationDrawer() { scope.launch { drawerState.close() } }
                }
            },
            gesturesEnabled = true,
        ){
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                HeaderToDo(Modifier.align(Alignment.TopEnd)) { scope.launch { drawerState.open() } } }
                BodyToDo(Modifier.align(Alignment.BottomCenter),
                    {navTarea()},
                    {navProgresion()},
                    {navObjetivo()},
                )//loginVM
            }
        }

    }




@Composable
fun MyNavigationDrawer(onCloseDrawer: () -> Unit) {
    val col = Color(0xFF84C4B4)
    val back_col = Color(0xFFADA576)
    Box (modifier = Modifier
        .background(color = back_col)
        .fillMaxWidth(.7f).
        fillMaxHeight()
    )
    {
        Column(modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top)
        {
            Box(modifier = Modifier.padding(10.dp)
            ){
                Text(modifier = Modifier.padding(10.dp),
                    text = "Modal Drawer",
                    fontSize = 27.sp
                )
            }
            HorizontalDivider(Modifier.fillMaxWidth())
            Button(modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                onClick = {},
                content = {Text("Log in")}
            )
            HorizontalDivider(Modifier.fillMaxWidth())
            Button(modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                onClick = {},
                content = {Text("Log in")}
            )
            HorizontalDivider(Modifier.fillMaxWidth())
            Button(modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                onClick = {},
                content = {Text("Log in")}
            )
            HorizontalDivider(Modifier.fillMaxWidth())
        }

        Column(modifier = Modifier.padding(20.dp)
            .align(alignment = Alignment.BottomEnd),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom)
        {
            HorizontalDivider(Modifier.fillMaxWidth())
            Button(modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                onClick = {},
                content = {Text("Log in")}
            )
            HorizontalDivider(Modifier.fillMaxWidth())
        }
    }



}



@Composable
fun BodyToDo(
    mod: Modifier,
    navTarea:() -> Unit,
    navProgresion: () -> Unit,
    navObjetivo: () -> Unit,
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
                 onClick = {},
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
fun HeaderToDo(mod: Modifier, function: () -> Unit) {

    Column {
        Spacer(modifier = Modifier.size(30.dp))
        Row(modifier = mod
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){

            Icon(imageVector = Icons.Default.Menu,
                contentDescription = "Close APP",
                modifier = mod
                    .clickable {function()}
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.size(40.dp))
            Row {

                Text(text = "TO-DO",
                    modifier = mod,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}






