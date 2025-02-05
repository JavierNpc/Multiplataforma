package com.example.todo_javier.toDo_MVVM.Model

import androidx.activity.ComponentActivity
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_javier.core.navegacion.NavigationController
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


@Preview ( showBackground = true)
@Composable
fun Vista (){
    NavigationController()
}



@Composable
fun To_Do(
    navTarea: () -> Unit,
    navProgreso: () -> Unit
    ){
    val buttonsColor = Color(0xFF9D8444)
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    Box(Modifier.background(color = Color(0xFFD2CCA8))){
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    MyNavigationDrawer(buttonsColor) { scope.launch { drawerState.close() } }
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
                BodyToDo(Modifier.align(Alignment.Center),
                    {navTarea()},
                    {navProgreso()},
                    buttonsColor
                )//loginVM
            }
        }

    }




@Composable
fun MyNavigationDrawer(buttonsColor: Color, onCloseDrawer: () -> Job) {
    val backCol = Color(0xFFADA576)
    val context = LocalContext.current
    Box (modifier = Modifier
        .background(color = backCol)
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
                colors = ButtonColors(
                    containerColor = buttonsColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified,
                ),
                onClick = {},
                content = {Text("Log in")}
            )
            HorizontalDivider(Modifier.fillMaxWidth())
            Button(modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                colors = ButtonColors(
                    containerColor = buttonsColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified,
                ),
                onClick = {},
                content = {Text("Log in")}
            )
            HorizontalDivider(Modifier.fillMaxWidth())
            Button(modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                colors = ButtonColors(
                    containerColor = buttonsColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified,
                ),
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
                colors = ButtonColors(
                    containerColor = Color(0xFFAB3232),
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFF6E1111),
                    disabledContentColor = Color.Unspecified,
                ),
                onClick = {(context as ComponentActivity).finish()},
                content = {Text("Cerrar Aplicacion")}
            )
            HorizontalDivider(Modifier.fillMaxWidth())
        }
    }



}



@Composable
fun BodyToDo(
    mod: Modifier,
    navTarea: () -> Unit,
    navProgreso: () -> Unit,
    buttonsColor: Color
) {
    val separacion = 40
    val altura = 200


     Box (modifier = mod.fillMaxWidth(.9f),) {
         Column (modifier = Modifier
             .fillMaxWidth()
             .fillMaxHeight(.7f),
             verticalArrangement = Arrangement.Center)
         {
             BotonInicio("TAREAS", navTarea )
             Spacer(Modifier.size(16.dp))
             BotonInicio("PROGRESO", navProgreso)
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
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun BotonInicio(title: String, navegar: () -> Unit) {
    Card( shape = RoundedCornerShape(16.dp),
        onClick = {navegar()},
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .shadow(6.dp, shape = RoundedCornerShape(16.dp)),
        colors = CardColors(
            containerColor = Color.Unspecified,
            contentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
        ),

    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}






