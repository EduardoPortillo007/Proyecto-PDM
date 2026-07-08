package com.example.zeppedapp.dominio.usecase.inventario

import com.example.zeppedapp.dominio.repository.InventarioRepository
import com.example.zeppedapp.utils.Resource

class UpdateInventarioUC(
    private val repository: InventarioRepository
) {
    suspend operator fun invoke(id: Int, stockActual: Double): Resource<Unit> {
        if (stockActual < 0) {
            return Resource.Error("El stock no puede ser negativo")
        }
        return repository.updateStock(id, stockActual)
    }
}