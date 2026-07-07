package com.example.zeppedapp.data.local.mappers

import com.example.zeppedapp.data.local.entity.IngredienteEntity
import com.example.zeppedapp.dominio.model.Ingrediente

fun IngredienteEntity.toDomain(): Ingrediente {
    return Ingrediente(
        id = id,
        nombre = nombre,
        stockActual = stockActual,
        unidad = unidad
    )
}

fun Ingrediente.toEntity(): IngredienteEntity {
    return IngredienteEntity(
        id = id,
        nombre = nombre,
        stockActual = stockActual,
        unidad = unidad
    )
}