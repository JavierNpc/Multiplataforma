package com.example.todo_javier.View.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun DialogoFiltro(
    show : Boolean = true
){
    var text by remember { mutableStateOf("") }

    if (show){
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = false
            )
        ) {
            Column(modifier = Modifier
                .background(Color.White , RoundedCornerShape(16.dp))
                .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Column (modifier = Modifier.fillMaxWidth().height(120.dp),
                    verticalArrangement = Arrangement.SpaceAround) {
                    Text("PORQUE QUIERES FILTRAR: ", fontSize = 20.sp)
                    Dropdown()
                }
                Spacer(Modifier.height(16.dp))
                TextField( value = text, onValueChange = { text = it },
                    placeholder = { Text("Filtro", color =  Color.Gray) },
                    shape = RoundedCornerShape(24.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent, // Quita la línea cuando está enfocado
                        unfocusedIndicatorColor = Color.Transparent, // Quita la línea cuando no está enfocado
                        disabledIndicatorColor = Color.Transparent // Quita la línea si está deshabilitado
                    ),
                )
                Spacer(Modifier.height(16.dp))
                TextButton(onClick = {}  ) { Text("Filtrar") }


            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun Ver_dialogo (){
    Box(modifier = Modifier.fillMaxWidth()){
        DialogoFiltro(show = true)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown() {
    val opciones = listOf("Id", "Titulo")
    var seleccionada by remember { mutableStateOf(opciones[0]) }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }


    ) {
        TextField(
            value = seleccionada,
            textStyle = TextStyle(fontSize = 16.sp),
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.menuAnchor(),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent, // Quita la línea cuando está enfocado
                unfocusedIndicatorColor = Color.Transparent, // Quita la línea cuando no está enfocado
                disabledIndicatorColor = Color.Transparent // Quita la línea si está deshabilitado
            ),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },

            
        ) {
            opciones.forEach { opcion ->
                DropdownMenuItem(

                    text = { Text(opcion) },
                    onClick = {
                        seleccionada = opcion
                        expanded = false
                    }
                )
            }
        }
    }
}


