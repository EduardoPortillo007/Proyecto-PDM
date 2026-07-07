package com.example.zeppedapp.dominio.usecase.producto

import com.example.zeppedapp.dominio.model.Producto
import com.example.zeppedapp.dominio.repository.ProductoRepository
import com.example.zeppedapp.utils.Resource

class GetProductosUC(
    private val repository: ProductoRepository
) {
    suspend operator fun invoke(): Resource<List<Producto>> {
        return repository.getProductos()
    }
}