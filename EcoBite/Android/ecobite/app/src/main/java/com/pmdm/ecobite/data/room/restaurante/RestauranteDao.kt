package com.pmdm.ecobite.data.room.restaurante

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface RestauranteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurante: RestauranteEntity)

    @Query("SELECT * FROM restaurantes")
    suspend fun getAll(): List<RestauranteEntity>

    @Query("SELECT * FROM restaurantes WHERE idRestaurante IN (:id)")
    suspend fun getById(id:Int): RestauranteEntity

    @Update
    suspend fun update(restaurante: RestauranteEntity)

    @Query("SELECT COUNT(*) FROM restaurantes")
    suspend fun count(): Int
}