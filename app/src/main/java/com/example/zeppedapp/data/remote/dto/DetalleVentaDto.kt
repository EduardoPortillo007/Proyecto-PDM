package com.example.zeppedapp.data.remote.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//conversión automatica de json a class, cammelcase a snake case
@Serializable
data class DetalleVentaDto(
    val id: Int,
    @SerialName("venta_id")
    val ventaId: Int,
    @SerialName("producto_id")
    val productoId: Int,
    val cantidad: Int,
    @SerialName("precio_unitario")
    val precioUnitario: Double,
    val subtotal: Double,
    @SerialName("ingredientes_excluidos")
    val ingredientesExcluidos: List<String>
)