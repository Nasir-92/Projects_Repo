package com.pmdm.ecobite.data.room.receta

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.pmdm.ecobite.models.Receta

@Dao
interface RecetaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(receta: RecetaEntity)

    @Query("SELECT * FROM recetas")
    suspend fun getAll(): List<RecetaEntity>

    @Query("SELECT * FROM recetas WHERE idReceta IN (:id)")
    suspend fun getById(id:Int): RecetaEntity

    @Query("SELECT * FROM recetas WHERE idRestaurante IN (:idRestaurante)")
    suspend fun getByRestaurante(idRestaurante:Int):List<RecetaEntity>

    @Update
    suspend fun update(receta: RecetaEntity)

    @Query("DELETE FROM recetas WHERE idReceta = :id")
    suspend fun delete(id:Int)
}