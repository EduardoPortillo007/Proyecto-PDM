package com.example.zeppedapp.dominio.model

// domain/model/Producto.kt
data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenUrl: String?
)