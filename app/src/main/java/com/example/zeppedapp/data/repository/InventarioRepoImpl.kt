package com.example.zeppedapp.data.repository

import com.example.zeppedapp.data.remote.api.ktorClient
import com.example.zeppedapp.data.remote.dto.IngredienteDto
import com.example.zeppedapp.data.remote.mappers.toDomain
import com.example.zeppedapp.dominio.model.Ingrediente
import com.example.zeppedapp.dominio.repository.InventarioRepository
import com.example.zeppedapp.utils.Resource
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import io.ktor.client.request.parameter

class InventarioRepositoryImpl : InventarioRepository {

    override suspend fun getInventario(): Resource<List<Ingrediente>> {
        return try {
            val response = ktorClient.get("/rest/v1/Ingrediente") {
                headers.append("Prefer", "return=representation")
            }
            val dtos = response.body<List<IngredienteDto>>()
            Resource.Success(dtos.map { it.toDomain() })
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error desconocido")
        }
    }

    override suspend fun updateStock(id: Int, stockActual: Double): Resource<Unit> {
        return try {
            ktorClient.patch("/rest/v1/Ingrediente") {
                parameter("id", "eq.$id")
                headers.append("Prefer", "return=representation")
                setBody(mapOf("stock_actual" to stockActual))
            }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error desconocido")
        }
    }
}