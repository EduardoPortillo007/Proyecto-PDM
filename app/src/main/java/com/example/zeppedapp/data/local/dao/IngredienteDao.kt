package com.example.zeppedapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.zeppedapp.data.local.entity.IngredienteEntity

@Dao
interface IngredienteDao {
    @Query("SELECT * FROM ingrediente")
    suspend fun getIngredientes(): List<IngredienteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredientes(ingredientes: List<IngredienteEntity>)

    @Update
    suspend fun updateIngrediente(ingrediente: IngredienteEntity)
}