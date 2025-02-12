package com.example.todo_javier.toDo_MVVM.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_javier.Models.EditableCardItem


class TareasViewModel : ViewModel() {

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
        itemIdCounter--
    }
}
