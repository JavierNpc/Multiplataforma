package com.example.todo_javier.View

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_javier.Models.EditableCardItem
import com.example.todo_javier.R
import com.example.todo_javier.toDo_MVVM.ViewModel.TareasViewModel


@Composable
fun ModeloTareas(viewModel: TareasViewModel, navHome: () -> Unit) {
    val buttonsColor = Color(0xFF9D8444)

    Scaffold(
        topBar = { HeaderTareas(buttonsColor) },
        content = { padding ->
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(padding)
            ) {
                BodyTareas(viewModel, Modifier.align(Alignment.Center), buttonsColor)
            }
        },
        bottomBar = { MenuTareas(viewModel,navHome) }
    )
}



@Composable
fun BodyTareas(viewModel: TareasViewModel, mod: Modifier, buttonsColor: Color) {
    val listaDeCards by viewModel.listaDeCards.observeAsState(emptyList())

    Column(
        modifier = mod.padding(20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF9B977A), shape = RoundedCornerShape(10.dp))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(530.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listaDeCards) { item ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        EditableCard(
                            item = item,
                            onTextChange = { newText -> viewModel.actualizarTarea(item.id, newText) }
                        )
                        Button(
                            onClick = { viewModel.eliminarTarea(item.id) },
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = buttonsColor,
                                contentColor = Color.White
                            ),
                            modifier = Modifier.size(60.dp)
                                .shadow(8.dp, shape = RoundedCornerShape(20.dp))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Eliminar Tarea",
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(mod.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { viewModel.agregarTarea() },
                modifier = Modifier.size(80.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonsColor,
                    contentColor = Color.White
                )
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Tarea", modifier = Modifier.size(30.dp))
            }
        }
    }
}


@Composable
fun EditableCard(item: EditableCardItem, onTextChange: (String) -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardColors(
            containerColor = Color(0xFFBCBFC2),
            contentColor = Color.White,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
        )
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Tarea ${item.id}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            BasicTextField(
                value = item.text,
                onValueChange = onTextChange,
                modifier = Modifier.fillMaxWidth(0.8f),
                textStyle = MaterialTheme.typography.bodyMedium,
                maxLines = 5
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderTareas(buttonsColor: Color) {
    TopAppBar(
        title = {
            Text("TAREAS", fontSize = 30.sp,
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
fun MenuTareas(viewModel: TareasViewModel, navHome: () -> Unit) {
    val context = LocalContext.current
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
                    .clickable {navHome()}
                    .size(40.dp)
            )

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar",
                modifier = Modifier
                    .clickable {}
                    .size(40.dp)
            )

            Icon(
                imageVector =  Icons.Default.Refresh,
                contentDescription = "Refresh",
                modifier = Modifier
                    .clickable {
                        viewModel.reiniciarContador();
                        Toast.makeText(context, "¡Contador actualizado a 0 !", Toast.LENGTH_SHORT).show()

                    }
                    .size(40.dp)
            )
        }
    }
}






