package com.pmdm.ecobite.data.room.usuario

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.pmdm.ecobite.data.room.restaurante.RestauranteEntity
import com.pmdm.ecobite.models.Usuario
@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: UsuarioEntity)

    @Query("SELECT * FROM usuarios")
    suspend fun getAll(): List<UsuarioEntity>

    @Query("SELECT * FROM usuarios WHERE idUsuario IN (:id)")
    suspend fun getById(id:Int): UsuarioEntity

    @Query("SELECT * FROM usuarios WHERE email IN(:email)")
    suspend fun getByEmail(email: String): UsuarioEntity

    @Update
    suspend fun update(evento: UsuarioEntity)

    @Query("SELECT COUNT(*) FROM usuarios")
    suspend fun count(): Int
}