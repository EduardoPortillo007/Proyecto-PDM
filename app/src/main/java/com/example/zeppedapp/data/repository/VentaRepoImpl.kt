package com.example.zeppedapp.data.repository

import com.example.zeppedapp.data.remote.api.ktorClient
import com.example.zeppedapp.data.remote.dto.VentaDto
import com.example.zeppedapp.data.remote.dto.DetalleVentaDto
import com.example.zeppedapp.data.remote.mappers.toDomain
import com.example.zeppedapp.dominio.model.Venta
import com.example.zeppedapp.dominio.model.DetalleVenta
import com.example.zeppedapp.dominio.repository.VentaRepository
import com.example.zeppedapp.utils.Resource
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class VentaRepositoryImpl : VentaRepository {

    override suspend fun getVentas(): Resource<List<Venta>> {
        return try {
            val response = ktorClient.get("/rest/v1/Venta") {
                headers.append("Prefer", "return=representation")
            }
            val dtos = response.body<List<VentaDto>>()
            Resource.Success(dtos.map { it.toDomain() })
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error desconocido")
        }
    }

    override suspend fun registrarVenta(venta: Venta, detalle: List<DetalleVenta>): Resource<Unit> {
        return try {
            // Primero registramos la venta
            val ventaResponse = ktorClient.post("/rest/v1/Venta") {
                headers.append("Prefer", "return=representation")
                setBody(venta)
            }
            val ventaCreada = ventaResponse.body<List<VentaDto>>().first()

            // Luego registramos el detalle con el id de la venta creada
            val detalleConId = detalle.map { it.copy(ventaId = ventaCreada.id) }
            ktorClient.post("/rest/v1/DetalleVenta") {
                headers.append("Prefer", "return=representation")
                setBody(detalleConId)
            }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error desconocido")
        }
    }
}