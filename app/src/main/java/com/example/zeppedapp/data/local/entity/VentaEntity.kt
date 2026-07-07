package com.example.zeppedapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venta")
data class VentaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val total: Double,
    val fecha: String,
    val estado: String
)