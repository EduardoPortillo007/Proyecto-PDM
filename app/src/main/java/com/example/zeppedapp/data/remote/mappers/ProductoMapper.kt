package com.example.zeppedapp.data.remote.mappers

import com.example.zeppedapp.data.remote.dto.ProductoDto
import com.example.zeppedapp.dominio.model.Producto

fun ProductoDto.toDomain(): Producto {
    return Producto(
        id = id,
        nombre = nombre,
        precio = precio,
        imagenUrl = imagenUrl
    )
}