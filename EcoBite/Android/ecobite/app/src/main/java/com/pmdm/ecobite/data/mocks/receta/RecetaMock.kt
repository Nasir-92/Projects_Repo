package com.pmdm.ecobite.data.mocks.receta

import java.time.LocalDateTime

data class RecetaMock(
    val idReceta: Int,
    val idRestaurante: Int,
    val nombre: String,
    val descripcion: String,
    val pasos: String,
    val imagen: String,
    val createdAt: LocalDateTime
)
