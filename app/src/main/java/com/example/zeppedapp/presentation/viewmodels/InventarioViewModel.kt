package com.example.zeppedapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeppedapp.data.repository.InventarioRepositoryImpl
import com.example.zeppedapp.dominio.model.Ingrediente
import com.example.zeppedapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InventarioViewModel : ViewModel() {

    private val repository = InventarioRepositoryImpl()

    private val _inventario = MutableStateFlow<Resource<List<Ingrediente>>>(Resource.Loading)
    val inventario: StateFlow<Resource<List<Ingrediente>>> = _inventario

    init {
        getInventario()
    }

    fun getInventario() {
        viewModelScope.launch {
            _inventario.value = Resource.Loading
            _inventario.value = repository.getInventario()
        }
    }

    fun updateStock(id: Int, stockActual: Double) {
        viewModelScope.launch {
            repository.updateStock(id, stockActual)
            getInventario() // recarga la lista después de actualizar
        }
    }
}