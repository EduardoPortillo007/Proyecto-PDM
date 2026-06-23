package com.example.zeppedapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VentaDto(
    val id: Int,
    val total: Double,
    val fecha: String,
    val estado: String
)