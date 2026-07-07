package com.example.zeppedapp.data.remote.dto

import kotlinx.serialization.Serializable


//conversión automatica de json a class, cammelcase a snake case
@Serializable
data class VentaDto(
    val id: Int,
    val total: Double,
    val fecha: String,
    val estado: String
)