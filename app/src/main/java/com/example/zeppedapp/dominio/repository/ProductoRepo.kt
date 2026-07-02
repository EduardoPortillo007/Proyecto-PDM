package com.example.zeppedapp.dominio.repository

import com.example.zeppedapp.dominio.model.Producto
import com.example.zeppedapp.utils.Resource

interface ProductoRepository {
    suspend fun getProductos(): Resource<List<Producto>>
    suspend fun addProducto(producto: Producto): Resource<Unit>
}