package com.example.zeppedapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeppedapp.data.repository.VentaRepositoryImpl
import com.example.zeppedapp.dominio.model.DetalleVenta
import com.example.zeppedapp.dominio.model.Venta
import com.example.zeppedapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VentaViewModel : ViewModel() {

    private val repository = VentaRepositoryImpl()

    private val _ventas = MutableStateFlow<Resource<List<Venta>>>(Resource.Loading)
    val ventas: StateFlow<Resource<List<Venta>>> = _ventas

    private val _registroExitoso = MutableStateFlow(false)
    val registroExitoso: StateFlow<Boolean> = _registroExitoso

    init {
        getVentas()
    }

    fun getVentas() {
        viewModelScope.launch {
            _ventas.value = Resource.Loading
            _ventas.value = repository.getVentas()
        }
    }

    fun registrarVenta(venta: Venta, detalle: List<DetalleVenta>) {
        viewModelScope.launch {
            val result = repository.registrarVenta(venta, detalle)
            _registroExitoso.value = result is Resource.Success
        }
    }
}