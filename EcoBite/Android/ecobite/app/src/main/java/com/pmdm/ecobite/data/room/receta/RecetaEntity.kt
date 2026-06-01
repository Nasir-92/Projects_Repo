package com.pmdm.ecobite.data.room.receta

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "recetas")
data class RecetaEntity(
    @PrimaryKey(autoGenerate = true)
    val idReceta: Int,
    val idRestaurante: Int,
    val nombre: String,
    val descripcion: String,
    val pasos: String,
    val imagen: String,
    val createdAt: LocalDateTime
)