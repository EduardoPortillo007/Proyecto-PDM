package com.example.zeppedapp.dominio.model

data class ProductoIngrediente(
    val id: Int,
    val productoId: Int,
    val ingredienteId: Int,
    val cantidadRequerida: Double,
    val esOpcional: Boolean   // false = fijo, true = a elección del cliente
)