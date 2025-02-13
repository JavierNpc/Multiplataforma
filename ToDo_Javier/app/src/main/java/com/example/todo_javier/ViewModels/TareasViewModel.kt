package com.example.todo_javier.toDo_MVVM.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_javier.Models.EditableCardItem


class TareasViewModel : ViewModel() {

    private val _opciones = MutableLiveData(listOf("Id", "Titulo"))
    val opciones : LiveData<List<String>> = _opciones

    private val _seleccionada = MutableLiveData<String>()
    var seleccionada : LiveData<String> = _seleccionada

    private val _expanded = MutableLiveData<Boolean>()
    var expanded : LiveData<Boolean> = _expanded


    private val _textoFiltro = MutableLiveData<String>()
    val textoFiltro: LiveData<String> = _textoFiltro


    private val _estadoDialogo = MutableLiveData<Boolean>()
    val estadoDialogo: LiveData<Boolean> = _estadoDialogo

    private val _listaDeCards = MutableLiveData(listOf(EditableCardItem(0, "Tarjeta prueba 0")))
    val listaDeCards: LiveData<List<EditableCardItem>> = _listaDeCards

    private var itemIdCounter = 1

    // Agregar una nueva tarea
    fun agregarTarea() {
        val nuevaLista = _listaDeCards.value.orEmpty() + EditableCardItem(itemIdCounter, "Elemento #$itemIdCounter")
        _listaDeCards.value = nuevaLista
        itemIdCounter++
    }

    // Editar el texto de una tarea
    fun actualizarTarea(id: Int, nuevoTexto: String) {
        val nuevaLista = _listaDeCards.value?.map {
            if (it.id == id) it.copy(text = nuevoTexto) else it
        }
        _listaDeCards.value = nuevaLista
    }

    // Eliminar una tarea
    fun eliminarTarea(id: Int) {
        val nuevaLista = _listaDeCards.value?.filterNot { it.id == id }
        _listaDeCards.value = nuevaLista

    }

    fun reiniciarContador(){
        itemIdCounter = 0
    }

    fun cambiarEstado(estadoentrante: Boolean) {
        _estadoDialogo.value = estadoentrante
    }

    fun actualizarSeleccion(newValor :String){
        _seleccionada.value = newValor
    }

    fun actualizarExpand(newBoolean: Boolean){
        _expanded.value = newBoolean
    }

    fun actualizarTextofiltro(newString: String){
        _textoFiltro.value = newString
    }


}


