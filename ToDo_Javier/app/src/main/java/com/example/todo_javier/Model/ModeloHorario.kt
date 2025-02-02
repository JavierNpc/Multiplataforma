package com.example.todo_javier.toDo_MVVM.Model

import android.view.RoundedCorner
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.todo_javier.R


@Preview( showBackground = true)
@Composable
fun Vistar (){
    ModeloHorario()
}



@Composable
fun ModeloHorario(/*navHome: () -> Unit*/){

    Box(Modifier.background(color = Color(0xFFD2CCA8))
        .fillMaxSize()
    ){

        Box(
            Modifier
                .fillMaxSize()
                .padding(20.dp)


        ) {
            HeaderHorario(Modifier.align(Alignment.TopCenter))
            MenuLateral(Modifier.align(Alignment.CenterEnd))
            BodyHorario(Modifier.align(Alignment.CenterStart)
            )
        }
    }

}

@Composable
fun BodyHorario(mod: Modifier) {
    val n = 6
    val filas = (0..7).map {}
    val columas = (0..n).map {"columna $it" }

    Column(modifier = mod) {
        Spacer(modifier = Modifier.size(80.dp))
        Box(modifier = Modifier
            .background( Color(0xFF9B977A))
            .width(270.dp)
            .height(610.dp)

        ){
            LazyRow(){
                itemsIndexed(filas){ indexfila, filas ->
                    LazyColumn(modifier = Modifier
                        .fillMaxHeight()
                        .border(.5.dp , color = Color.Black),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        itemsIndexed(columas){ indexcol, col->


                            if (indexfila == 0 && indexcol == 0 ){
                                Box(modifier = Modifier.padding(10.dp)){
                                    Text("")
                                }
                            }else if(indexfila == 1 && indexcol==0){
                                Box(modifier = Modifier.padding(10.dp)){
                                    Text("LUNES")
                                }
                            }else{
                                Box(modifier = Modifier.padding(10.dp)){
                                    Text(col)
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}

//@Composable
//fun ColumnasHorario(){
//
//        Column {
//            Text("Columna $it ")
//        }
//
//}


@Composable
fun HeaderHorario(mod: Modifier) {
   Column{
       Spacer(modifier = Modifier.size(40.dp))
       Row(modifier = mod.fillMaxWidth()) {
           Spacer(modifier = Modifier.size(40.dp))
           Text(modifier = Modifier,
               fontSize = 35.sp,

               text = "Horario")
       }
   }

}

@Composable
fun MenuLateral(mod: Modifier) {
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



