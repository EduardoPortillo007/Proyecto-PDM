package com.example.zeppedapp.data.local.mappers

import com.example.zeppedapp.data.local.entity.DetalleVentaEntity
import com.example.zeppedapp.data.local.entity.VentaEntity
import com.example.zeppedapp.dominio.model.DetalleVenta
import com.example.zeppedapp.dominio.model.Venta

fun VentaEntity.toDomain(): Venta {
    return Venta(
        id = id,
        total = total,
        fecha = fecha,
        estado = estado
    )
}

fun Venta.toEntity(): VentaEntity {
    return VentaEntity(
        id = id,
        total = total,
        fecha = fecha,
        estado = estado
    )
}

fun DetalleVentaEntity.toDomain(): DetalleVenta {
    return DetalleVenta(
        id = id,
        ventaId = ventaId,
        productoId = productoId,
        cantidad = cantidad,
        precioUnitario = precioUnitario,
        subtotal = subtotal,
        ingredientesExcluidos = ingredientesExcluidos
            .split(",")
            .filter { it.isNotBlank() }
    )
}

fun DetalleVenta.toEntity(): DetalleVentaEntity {
    return DetalleVentaEntity(
        id = id,
        ventaId = ventaId,
        productoId = productoId,
        cantidad = cantidad,
        precioUnitario = precioUnitario,
        subtotal = subtotal,
        ingredientesExcluidos = ingredientesExcluidos.joinToString(",")
    )
}