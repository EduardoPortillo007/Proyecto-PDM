package com.example.zeppedapp.data.remote.dto
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


//conversión automatica de json a class, cammelcase a snake case
@Serializable
data class IngredienteDto(
    val id: Int,
    val nombre: String,
    @SerialName("stock_actual")
    val stockActual: Double,
    val unidad: String
)