package com.example.zeppedapp.data.remote.mappers

import com.example.zeppedapp.data.remote.dto.IngredienteDto
import com.example.zeppedapp.dominio.model.Ingrediente


//conversión de DTO a Model para enviar al model
fun IngredienteDto.toDomain(): Ingrediente {
    return Ingrediente(
        id = id,
        nombre = nombre,
        stockActual = stockActual,
        unidad = unidad
    )
}