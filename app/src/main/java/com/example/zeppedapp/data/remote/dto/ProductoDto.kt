package com.example.zeppedapp.data.remote.dto

import kotlinx.serialization.Serializable


//conversión automatica de json a class, cammelcase a snake case
@Serializable
data class ProductoDto(
    val id: Int,
    val nombre: String,
    val precio: Double
)