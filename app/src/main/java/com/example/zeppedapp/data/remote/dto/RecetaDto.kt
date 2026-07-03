package com.example.zeppedapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//conversión automatica de json a class, cammelcase a snake case
@Serializable
data class RecetaDto(
    val id: Int,
    @SerialName("producto_id")
    val productoId: Int,
    @SerialName("ingrediente_id")
    val ingredienteId: Int,
    @SerialName("cantidad_requerida")
    val cantidadRequerida: Double,
    @SerialName("es_opcional")
    val esOpcional: Boolean
)