package com.example.zeppedapp.dominio.usecase.venta

import com.example.zeppedapp.dominio.repository.VentaRepository
import com.example.zeppedapp.dominio.model.Venta
import com.example.zeppedapp.dominio.model.DetalleVenta
import com.example.zeppedapp.utils.Resource

class RegistroVentaUC(
    private val repository: VentaRepository
) {
    suspend operator fun invoke(venta: Venta, detalle: List<DetalleVenta>): Resource<Unit> {
        if (detalle.isEmpty()) {
            return Resource.Error("La venta debe tener al menos un producto")
        }
        if (venta.total <= 0) {
            return Resource.Error("El total de la venta debe ser mayor a cero")
        }
        return repository.registrarVenta(venta, detalle)
    }
}