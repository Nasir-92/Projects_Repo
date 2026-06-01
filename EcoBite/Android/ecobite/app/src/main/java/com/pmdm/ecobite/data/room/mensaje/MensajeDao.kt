package com.pmdm.ecobite.data.room.mensaje

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MensajeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mensaje: MensajeEntity)

    @Query("SELECT * FROM mensajes")
    suspend fun getAll(): List<MensajeEntity>

    @Query("SELECT * FROM mensajes WHERE idMensaje IN (:id)")
    suspend fun getById(id:Int): MensajeEntity

    @Query("DELETE FROM mensajes WHERE idMensaje = :id")
    suspend fun delete(id:Int)
}