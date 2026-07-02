package com.example.zeppedapp.data.repository

import com.example.zeppedapp.data.remote.api.ktorClient
import com.example.zeppedapp.data.remote.dto.ProductoDto
import com.example.zeppedapp.data.remote.mappers.toDomain
import com.example.zeppedapp.utils.Resource
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import com.example.zeppedapp.dominio.model.Producto
import com.example.zeppedapp.dominio.repository.ProductoRepository

class ProductoRepositoryImpl : ProductoRepository {

    override suspend fun getProductos(): Resource<List<Producto>> {
        return try {
            val response = ktorClient.get("/rest/v1/productos") {
                headers.append("Prefer", "return=representation")
            }
            val dtos = response.body<List<ProductoDto>>()
            Resource.Success(dtos.map { it.toDomain() })
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error desconocido")
        }
    }

    override suspend fun addProducto(producto: Producto): Resource<Unit> {
        return try {
            ktorClient.post("/rest/v1/productos") {
                headers.append("Prefer", "return=representation")
                setBody(producto)
            }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error desconocido")
        }
    }
}


