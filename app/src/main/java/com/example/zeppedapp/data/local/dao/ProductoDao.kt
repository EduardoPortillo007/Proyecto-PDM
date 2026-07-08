package com.example.zeppedapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zeppedapp.data.local.entity.ProductoEntity

@Dao
interface ProductoDao {
    @Query("SELECT * FROM producto")
    suspend fun getProductos(): List<ProductoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductos(productos: List<ProductoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducto(producto: ProductoEntity)
}

