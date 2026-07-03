package com.example.zeppedapp.data.remote.mappers

import com.example.zeppedapp.data.remote.dto.ProductoDto
import com.example.zeppedapp.dominio.model.Producto


//Conversión de DTO a Mapper para enviar el model
fun ProductoDto.toDomain(): Producto {
    return Producto(
        id = id,
        nombre = nombre,
        precio = precio
    )
}