package com.example.zeppedapp.dominio.usecase.venta

import com.example.zeppedapp.dominio.repository.VentaRepository
import com.example.zeppedapp.dominio.model.Venta
import com.example.zeppedapp.utils.Resource

class GetVentaUC(
    private val repository: VentaRepository
) {
    suspend operator fun invoke(): Resource<List<Venta>> {
        return repository.getVentas()
    }
}