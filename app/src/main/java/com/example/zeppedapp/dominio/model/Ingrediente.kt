package com.example.zeppedapp.dominio.model

data class Ingrediente(
    val id: Int,
    val nombre: String,
    val stockActual: Double,
    val unidad: String        // "unidad", "gramos", "ml"
)