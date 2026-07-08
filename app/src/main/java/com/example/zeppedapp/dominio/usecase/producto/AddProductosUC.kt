package com.example.zeppedapp.dominio.usecase.producto

import com.example.zeppedapp.dominio.model.Producto
import com.example.zeppedapp.dominio.repository.ProductoRepository
import com.example.zeppedapp.utils.Resource

class AddProductosUC(
    private val repository: ProductoRepository
) {
    suspend operator fun invoke(producto: Producto): Resource<Unit> {
        if (producto.nombre.isBlank()) {
            return Resource.Error("El nombre del producto no puede estar vacío")
        }
        if (producto.precio <= 0) {
            return Resource.Error("El precio debe ser mayor a cero")
        }
        return repository.addProducto(producto)
    }
}