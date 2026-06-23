package com.example.zeppedapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductoDto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    @SerialName("imagen_url")
    val imagenUrl: String?
)