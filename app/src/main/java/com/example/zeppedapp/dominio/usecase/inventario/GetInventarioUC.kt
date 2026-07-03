package com.example.zeppedapp.dominio.usecase.inventario

import com.example.zeppedapp.dominio.repository.InventarioRepository
import com.example.zeppedapp.dominio.model.Ingrediente
import com.example.zeppedapp.utils.Resource

class GetInventarioUC(
    private val repository: InventarioRepository
) {
    suspend operator fun invoke(): Resource<List<Ingrediente>> {
        return repository.getInventario()
    }
}