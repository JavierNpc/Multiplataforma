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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_javier.R


@Preview( showBackground = true)
@Composable
fun VistarTareas(){
    ModeloTareas()
}



@Composable
fun ModeloTareas(/*navHome: () -> Unit*/){
    val buttonsColor = Color(0xFF9D8444)
    Box(Modifier.background(color = Color(0xFFD2CCA8))
        .fillMaxSize()
    ){

        Box(
            Modifier
                .fillMaxSize()
                .padding(20.dp)


        ) {
            HeaderTareas(Modifier.align(Alignment.TopCenter))
            BodyTareas(Modifier.align(Alignment.CenterStart),buttonsColor )
            MenuTareas(Modifier.align(Alignment.CenterEnd))

        }
    }

}

data class EditableCardItem(
    val id: Int,
    var text: String
)


@Composable
fun BodyTareas(mod: Modifier, buttonsColor: Color) {
    var listaDeCards by remember { mutableStateOf(mutableListOf<EditableCardItem>()) }
    var itemIdCounter by remember { mutableIntStateOf(0) }

    Column(modifier = mod.offset(0.dp,30.dp)) {
        Box(modifier = Modifier
            .background( Color(0xFF9B977A), shape = RoundedCornerShape(10))
            .border(1.dp ,Color.Black, shape = RoundedCornerShape(10) )
            .width(270.dp)
            .height(560.dp)

        ){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listaDeCards) { item ->
                    EditableCard(
                        item = item,
                        onTextChange = { newText ->
                            listaDeCards = listaDeCards.map {
                                if (it.id == item.id) it.copy(text = newText) else it
                            }.toMutableList()
                        }
                    )
                }
            }
        }

        Box(modifier = mod
            .offset((10).dp,(30.dp))){
            Button(modifier = Modifier.size(70.dp),
                onClick = {
                    listaDeCards = (listaDeCards + EditableCardItem(itemIdCounter, "Elemento #$itemIdCounter")).toMutableList()
                    // Añadir un nuevo elemento a la lista
                    itemIdCounter++
                },
                content = {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = "Close APP",
                        modifier = Modifier.size(40.dp),
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
}

@Composable
fun EditableCard(item: EditableCardItem, onTextChange: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Tarea ${item.id}",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            BasicTextField(
                value = item.text,
                onValueChange = onTextChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium
            )
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
fun HeaderTareas(mod: Modifier) {
    Column(modifier = mod.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.size(40.dp))
        Row(modifier = mod){
            Text(modifier = Modifier,
                fontSize = 35.sp,
                text = "TAREAS"
            )
        }
    }

}

@Composable
fun MenuTareas(mod: Modifier) {
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



