package com.pmdm.ecobite.models

import java.time.LocalDateTime

data class Receta(
    val idReceta: Int,
    val idRestaurante: Int,
    val nombre: String,
    val descripcion: String,
    val pasos: String,
    val imagen: String,
    val createdAt: LocalDateTime
)