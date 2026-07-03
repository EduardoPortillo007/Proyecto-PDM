package com.example.zeppedapp.dominio.repository

import com.example.zeppedapp.dominio.model.Producto
import com.example.zeppedapp.utils.Resource

interface ProductoRepository {
    //funciones suspendidas para la espera de datos y resource en vez de try catch
    suspend fun getProductos(): Resource<List<Producto>>
    suspend fun addProducto(producto: Producto): Resource<Unit>
}