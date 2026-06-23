package com.example.zeppedapp.dominio.model

data class DetalleVenta(
    val id: Int,
    val ventaId: Int,
    val productoId: Int,
    val cantidad: Int,
    val precioUnitario: Double,
    val subtotal: Double,
    val ingredientesExcluidos: List<String>  // ["lechuga", "mostaza"]
)