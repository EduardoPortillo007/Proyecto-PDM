package com.example.zeppedapp.data.remote.mappers

import com.example.zeppedapp.data.remote.dto.IngredienteDto
import com.example.zeppedapp.dominio.model.Ingrediente

fun IngredienteDto.toDomain(): Ingrediente {
    return Ingrediente(
        id = id,
        nombre = nombre,
        stockActual = stockActual,
        unidad = unidad
    )
}