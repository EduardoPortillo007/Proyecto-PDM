package com.example.zeppedapp.dominio.repository

import com.example.zeppedapp.dominio.model.Ingrediente
import com.example.zeppedapp.utils.Resource

interface InventarioRepository {
    suspend fun getInventario(): Resource<List<Ingrediente>>
    suspend fun updateStock(id: Int, stockActual: Double): Resource<Unit>
}