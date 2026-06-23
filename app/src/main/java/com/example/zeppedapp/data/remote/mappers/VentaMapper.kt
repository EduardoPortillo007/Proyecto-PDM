package com.example.zeppedapp.data.remote.mappers

import com.example.zeppedapp.data.remote.dto.DetalleVentaDto
import com.example.zeppedapp.data.remote.dto.VentaDto
import com.example.zeppedapp.dominio.model.DetalleVenta
import com.example.zeppedapp.dominio.model.Venta

// data/remote/mappers/VentaMapper.kt
fun VentaDto.toDomain(): Venta {
    return Venta(
        id = id,
        total = total,
        fecha = fecha,
        estado = estado
    )
}

fun DetalleVentaDto.toDomain(): DetalleVenta {
    return DetalleVenta(
        id = id,
        ventaId = ventaId,
        productoId = productoId,
        cantidad = cantidad,
        precioUnitario = precioUnitario,
        subtotal = subtotal,
        ingredientesExcluidos = ingredientesExcluidos
    )
}