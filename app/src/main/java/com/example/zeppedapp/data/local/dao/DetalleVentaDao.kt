package com.example.zeppedapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zeppedapp.data.local.entity.DetalleVentaEntity

@Dao
interface DetalleVentaDao {
    @Query("SELECT * FROM detalle_venta WHERE ventaId = :ventaId")
    suspend fun getDetalleByVenta(ventaId: Int): List<DetalleVentaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetalle(detalle: List<DetalleVentaEntity>)
}