package com.example.zeppedapp.dominio.model

data class Venta(
    val id: Int,
    val total: Double,
    val fecha: String,
    val estado: String        // "completada", "cancelada"
)