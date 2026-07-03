package com.example.zeppedapp.dominio.repository

import com.example.zeppedapp.dominio.model.Venta
import com.example.zeppedapp.dominio.model.DetalleVenta
import com.example.zeppedapp.utils.Resource

interface VentaRepository {
    suspend fun getVentas(): Resource<List<Venta>>
    suspend fun registrarVenta(venta: Venta, detalle: List<DetalleVenta>): Resource<Unit>
}