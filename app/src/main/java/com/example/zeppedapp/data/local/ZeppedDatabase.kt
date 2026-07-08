package com.example.zeppedapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zeppedapp.data.local.dao.DetalleVentaDao
import com.example.zeppedapp.data.local.dao.IngredienteDao
import com.example.zeppedapp.data.local.dao.ProductoDao
import com.example.zeppedapp.data.local.dao.VentaDao
import com.example.zeppedapp.data.local.entity.DetalleVentaEntity
import com.example.zeppedapp.data.local.entity.IngredienteEntity
import com.example.zeppedapp.data.local.entity.ProductoEntity
import com.example.zeppedapp.data.local.entity.VentaEntity

@Database(
    entities = [
        ProductoEntity::class,
        IngredienteEntity::class,
        VentaEntity::class,
        DetalleVentaEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ZeppedDatabase : RoomDatabase() {
    abstract fun productoDao(): ProductoDao
    abstract fun ingredienteDao(): IngredienteDao
    abstract fun ventaDao(): VentaDao
    abstract fun detalleVentaDao(): DetalleVentaDao
}