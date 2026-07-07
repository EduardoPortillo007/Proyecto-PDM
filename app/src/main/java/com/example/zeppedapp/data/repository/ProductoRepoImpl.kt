package com.example.zeppedapp.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.zeppedapp.ZeppedApp
import com.example.zeppedapp.data.local.mappers.toDomain
import com.example.zeppedapp.data.local.mappers.toEntity
import com.example.zeppedapp.data.remote.api.ktorClient
import com.example.zeppedapp.data.remote.dto.ProductoDto
import com.example.zeppedapp.data.remote.mappers.toDomain
import com.example.zeppedapp.dominio.model.Producto
import com.example.zeppedapp.dominio.repository.ProductoRepository
import com.example.zeppedapp.utils.Resource
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class ProductoRepositoryImpl(
    private val context: Context
) : ProductoRepository {

    private val dao = ZeppedApp.database.productoDao()

    override suspend fun getProductos(): Resource<List<Producto>> {
        return try {
            if (accesoWifi()) {
                // hay internet → sincroniza Supabase → Room
                val response = ktorClient.get("/rest/v1/Producto")
                val dtos = response.body<List<ProductoDto>>()
                val productos = dtos.map { it.toDomain() }
                // guarda en Room
                dao.insertProductos(productos.map { it.toEntity() })
                Resource.Success(productos)
            } else {
                // sin internet → lee de Room
                val local = dao.getProductos()
                Resource.Success(local.map { it.toDomain() })
            }
        } catch (e: Exception) {
            // si falla Supabase → intenta Room
            val local = dao.getProductos()
            if (local.isNotEmpty()) {
                Resource.Success(local.map { it.toDomain() })
            } else {
                Resource.Error(e.message ?: "Error desconocido")
            }
        }
    }

    override suspend fun addProducto(producto: Producto): Resource<Unit> {
        return try {
            if (accesoWifi()) {
                // guarda en Supabase
                ktorClient.post("/rest/v1/Producto") {
                    headers.append("Prefer", "return=representation")
                    setBody(producto)
                }
            }
            // siempre guarda en Room
            dao.insertProducto(producto.toEntity())
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error desconocido")
        }
    }

    private fun accesoWifi(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetwork ?: return false
        val capabilities = cm.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}

