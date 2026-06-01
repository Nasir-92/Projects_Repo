package com.pmdm.ecobite.data.room.restaurante

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "restaurantes")
data class RestauranteEntity(
    @PrimaryKey(autoGenerate = true)
    val idRestaurante: Int,
    val nombre: String,
    val email: String,
    val password: String,
    val telefono: String,
    val ubicacion: String,
    val horario: String,
    val descripcion: String,
    val imagen: String,
    val createdAt: LocalDateTime
)