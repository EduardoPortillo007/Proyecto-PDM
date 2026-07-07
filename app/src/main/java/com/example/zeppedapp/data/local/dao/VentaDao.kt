package com.example.zeppedapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zeppedapp.data.local.entity.VentaEntity

@Dao
interface VentaDao {
    @Query("SELECT * FROM venta")
    suspend fun getVentas(): List<VentaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVenta(venta: VentaEntity): Long
}