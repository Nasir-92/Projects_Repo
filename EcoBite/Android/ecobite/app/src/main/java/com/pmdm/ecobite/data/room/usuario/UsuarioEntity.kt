package com.pmdm.ecobite.data.room.usuario

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    val idUsuario: Int,
    val nombre: String,
    val apellidos: String,
    val telefono: String,
    val email: String,
    val password: String?,
    val ubicacion: String,
    val rol: String,
    val createdAt: String?
)