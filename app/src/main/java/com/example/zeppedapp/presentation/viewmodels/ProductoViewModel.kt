package com.example.zeppedapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeppedapp.data.repository.ProductoRepositoryImpl
import com.example.zeppedapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.zeppedapp.dominio.model.Producto

class ProductoViewModel : ViewModel() {

    //declaración
    private val repository = ProductoRepositoryImpl()


    private val _productos = MutableStateFlow<Resource<List<Producto>>>(Resource.Loading)//indicador de carga
    val productos: StateFlow<Resource<List<Producto>>> = _productos

    //se carga la lista
    init {
        getProductos()
    }

    fun getProductos() {
        viewModelScope.launch {
            _productos.value = Resource.Loading
            _productos.value = repository.getProductos()
        }
    }
}