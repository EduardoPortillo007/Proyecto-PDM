package com.example.zeppedapp.data.local.mappers

import com.example.zeppedapp.data.local.entity.ProductoEntity
import com.example.zeppedapp.dominio.model.Producto

fun ProductoEntity.toDomain(): Producto {
    return Producto(
        id = id,
        nombre = nombre,
        precio = precio
    )
}

fun Producto.toEntity(): ProductoEntity {
    return ProductoEntity(
        id = id,
        nombre = nombre,
        precio = precio
    )
}